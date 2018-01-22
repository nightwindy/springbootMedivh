package com.windy.medivh.core.service;

import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.rs.GetPolicy;
import com.qiniu.api.rs.URLUtils;

import java.net.URL;

public class QiNiuAccessPathService implements AccessPathService {

    private final String accessKey;
    private final String accessSecret;
    private final String domain;//私有空间域名

    public QiNiuAccessPathService(String accessKey, String accessSecret, String domain) {
        this.accessKey = accessKey;
        this.accessSecret = accessSecret;
        this.domain = domain;
    }

    @Override
    public String findAccessPath(String personUrl) throws Exception {
        URL url = new URL(personUrl);
        String path = url.getPath();
        String key = path.substring(1);

        URL domainUrl = new URL(domain);
        String newDomain = domainUrl.getHost();
        Mac mac = new Mac(accessKey, accessSecret);
        String baseUrl = URLUtils.makeBaseUrl(newDomain, key);
        GetPolicy getPolicy = new GetPolicy();
        return getPolicy.makeRequest(baseUrl, mac);
    }

    @Override
    public String findAccessPathWithExt(String personUrl) throws Exception {
        URL url = new URL(personUrl);
        String path = url.getPath();
        String key = path.substring(1);

        URL domainUrl = new URL(domain);
        String newDomain = domainUrl.getHost();
        Mac mac = new Mac(accessKey, accessSecret);
        String baseUrl = URLUtils.makeBaseUrl(newDomain, key);
        GetPolicy getPolicy = new GetPolicy();
        return getPolicy.makeRequest(baseUrl+"?"+ url.getQuery(), mac);
    }
}
