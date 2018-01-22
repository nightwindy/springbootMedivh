package com.windy.medivh.core.service;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface UploadService {

    String upload(File file) throws IOException;

    String upload(String fileName, byte[] stream) throws IOException;

    String fetch(String resource) throws IOException, NoSuchAlgorithmException, InvalidKeyException;

    /**
     * 大文件，断点续传
     * @param file
     * @return
     */
    String uploadResumeable(File file, String fileName) ;

    /**
     * 获取七牛上传token
     */
    String getAuthToken();
}
