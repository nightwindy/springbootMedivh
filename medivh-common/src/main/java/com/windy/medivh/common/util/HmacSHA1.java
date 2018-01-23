package com.windy.medivh.common.util;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by alex on 16/10/13.
 */
public class HmacSHA1 {

    private static final String MAC_NAME = "HmacSHA1";
    private static final String CHARSET = "UTF-8";


    public static Mac create(String key) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(CHARSET), MAC_NAME);
        Mac mac = Mac.getInstance(MAC_NAME);
        mac.init(secretKey);
        return mac;
    }
}
