package com.windy.medivh.core.service;

import com.google.gson.Gson;
import com.mhc.skoda.common.utils.HmacSHA1;
import com.mhc.skoda.common.utils.HttpClientUtils;
import com.mhc.skoda.common.utils.QiniuUrlSafeBase64;
import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by alex on 16/10/13.
 */
public final class QiNiuUploadServiceImpl extends AbstractUploadService {

    private static final Logger logger = LoggerFactory.getLogger(QiNiuUploadServiceImpl.class);
    private final String accessKey;
    private final String accessSecret;
    private final String domain;//开放空间域名
    private final String bucketName;//开放空间

    public QiNiuUploadServiceImpl(String accessKey, String accessSecret, String domain, String bucketName) {
        this.accessKey = accessKey;
        this.accessSecret = accessSecret;
        this.domain = domain;
        this.bucketName = bucketName;
    }

    public String upload(File file) throws IOException {

        if (file == null) throw new RuntimeException("文件不能为null");

        String fileName = file.getName();
        String extension = parseExtension(fileName);
        String newFileName = String.format("%s%s", UUID.randomUUID().toString().toUpperCase(), extension);

        try {
            return uploadToRemote(newFileName, file);
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public String upload(String fileName, byte[] content) throws IOException {
        File file = new File(fileName);
        try {
            FileUtils.writeByteArrayToFile(file, content);
            return upload(file);
        } finally {

        }
    }

    public String fetch(String resource) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        String key = UUID.randomUUID().toString().toUpperCase();

        String url = String.format("%s/fetch/%s/to/%s", "http://iovip.qbox.me", QiniuUrlSafeBase64.encodeToString(resource), QiniuUrlSafeBase64.encodeToString(String.format("%s:%s", bucketName, key)));

        String sign = signRequest(url);

        Map<String, String> header = new HashMap<>();
        header.put("Authorization", "QBox " + sign);

        HttpEntity entity = HttpClientUtils.post(url, header);


        String JSON = EntityUtils.toString(entity);

        Gson gson = new Gson();

        Map result = gson.fromJson(JSON, HashMap.class);

        if (result.containsKey("error")) {
            throw new Error(result.get("error").toString());
        }

        return domain + result.get("key").toString();
    }

    @Override
    public String uploadResumeable(File file, String fileName) {
        String url = "";
        if (file == null) throw new RuntimeException("文件不能为null");
        if (StringUtils.isEmpty(fileName)) {
            fileName = String.format("%s%s", UUID.randomUUID().toString().toUpperCase(), ".zip");
        }
        try {
            url = uploadResumeable(fileName, file);
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }
        return url;
    }

    private String uploadToRemote(String key, File file) {
        PutRet ret = IoApi.putFile(createUpToken(), key, file, new PutExtra());
        if (StringUtils.isBlank(ret.getKey())) {
            throw new Error("七牛上传文件失败");
        }
        return domain + ret.getKey();
    }

    private String uploadResumeable(String key, File file) {

        String url = "";
        try {
            String upToken = getAuthToken();
            //构造一个带指定Zone对象的配置类
            Configuration cfg = new Configuration(Zone.zone0());
            UploadManager uploadManager = new UploadManager(cfg);
            Response response = uploadManager.put(file.getAbsolutePath(), key, upToken);
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            url = domain + putRet.key;
        } catch (QiniuException e) {
            logger.error("文件上传失败", e);
        }
        return url;
    }

    /**
     * 七牛上传token
     *
     * @return
     * @throws AuthException
     */
    public String createUpToken() {
        Mac mac = new Mac(accessKey, accessSecret);
        PutPolicy putPolicy = new PutPolicy(bucketName);
        try {
            return putPolicy.token(mac);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public String signRequest(String urlString) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException {
        URI uri = URI.create(urlString);
        String path = uri.getRawPath();
        String query = uri.getRawQuery();

        javax.crypto.Mac mac = HmacSHA1.create(accessSecret);

        mac.update(path.getBytes("UTF-8"));
        if (query != null && query.length() != 0) {
            mac.update((byte) ('?'));
            mac.update(query.getBytes("UTF-8"));
        }
        mac.update((byte) '\n');

        String digest = QiniuUrlSafeBase64.encodeToString(mac.doFinal());

        return accessKey + ":" + digest;
    }

    /**
     * 文件上传的Token
     * @return
     */
    @Override
    public String getAuthToken() {
        Auth auth = Auth.create(accessKey, accessSecret);
        String upToken = auth.uploadToken(bucketName);
        return upToken;
    }

}
