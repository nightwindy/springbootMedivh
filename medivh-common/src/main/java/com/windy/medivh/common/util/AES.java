package com.windy.medivh.common.util;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by alex on 2016/11/4.
 */
public class AES {

    private static String DEFAULT_CHARSET = "UTF-8";
    private static String WORK_MODE = "AES/CBC/PKCS5Padding";
    private static String RANDOM = "SHA1PRNG";
    private static String ALGORITHM = "AES";

    private SecretKeySpec secretKeySpec;

    public AES(String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        SecureRandom random = SecureRandom.getInstance(RANDOM);
        random.setSeed(key.getBytes(DEFAULT_CHARSET));
        KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
        kgen.init(key.length() * 8, random);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        this.secretKeySpec = new SecretKeySpec(enCodeFormat, ALGORITHM);
    }

    public byte[] encrypt(String content) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(WORK_MODE);// 创建密码器
        byte[] byteContent = content.getBytes(DEFAULT_CHARSET);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(secretKeySpec.getEncoded());
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);// 初始化
        return cipher.doFinal(byteContent);
    }

    public byte[] decrypt(byte[] content) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(WORK_MODE);// 创建密码器
        IvParameterSpec ivParameterSpec = new IvParameterSpec(secretKeySpec.getEncoded());
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);// 初始化
        return cipher.doFinal(content);
    }
}
