package com.windy.medivh.core.service;

import com.mhc.skoda.common.filter.ExtensionFilter;
import com.mhc.skoda.common.filter.ImageExtensionFilter;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by alex on 16/10/13.
 */
public abstract class AbstractUploadService implements UploadService {

    private final String localFilePath = "/tmp/";//上传文件本地存储路径

    protected ExtensionFilter filter; //文件过滤器

    public AbstractUploadService() {
        filter = new ImageExtensionFilter();
    }

    public void setFilter(ExtensionFilter filter) {
        this.filter = filter;
    }

    protected String parseExtension(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            return ".jpg";
        }
        Integer lastIndexOf = fileName.lastIndexOf(".");
        if (lastIndexOf.equals(-1)) {
            return ".jpg";
        }
        return fileName.substring(fileName.lastIndexOf("."), fileName.length());
    }

//    protected void saveToLocal(String fileName, InputStream stream) throws IOException {
//
//        assert (StringUtils.isNotEmpty(fileName));
//
//        FileOutputStream outputStream = null;
//        try {
//            outputStream = new FileOutputStream(new File(String.format("%s%s", localFilePath, fileName)));
//            byte[] buf = new byte[1024];
//            while (stream.read(buf) > 0) {
//                outputStream.write(buf);
//            }
//        } catch (FileNotFoundException e) {
//            throw new Error(e);
//        } finally {
//            if (outputStream != null) {
//                outputStream.close();
//            }
//        }
//    }

//    protected void deleteFromLocal(String fileName) {
//
//        assert (StringUtils.isNotEmpty(fileName));
//
//        File file = new File(String.format("%s%s", localFilePath, fileName));
//        if (file.exists()) {
//            file.delete();
//        }
//    }
}
