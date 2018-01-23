package com.windy.medivh.common.util;

import java.io.UnsupportedEncodingException;

/**
 * Created by alex on 16/10/13.
 */
public class QiniuUrlSafeBase64 {

    private QiniuUrlSafeBase64() {
    }   // don't instantiate

    /**
     * 编码字符串
     *
     * @param data 待编码字符串
     * @return 结果字符串
     */
    public static String encodeToString(String data) throws UnsupportedEncodingException {
        return encodeToString(data.getBytes("UTF-8"));
    }

    /**
     * 编码数据
     *
     * @param data 字节数组
     * @return 结果字符串
     */
    public static String encodeToString(byte[] data) {
        return QiniuBase64.encodeToString(data, QiniuBase64.URL_SAFE | QiniuBase64.NO_WRAP);
    }

    /**
     * 解码数据
     *
     * @param data 编码过的字符串
     * @return 原始数据
     */
    public static byte[] decode(String data) {
        return QiniuBase64.decode(data, QiniuBase64.URL_SAFE | QiniuBase64.NO_WRAP);
    }
}
