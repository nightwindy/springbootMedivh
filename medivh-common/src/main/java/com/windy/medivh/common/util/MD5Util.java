package com.windy.medivh.common.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by qinyisheng on 16/9/30.
 */
public class MD5Util {
    private final static String KEY = "woshimaihaoche";
    private final static String KEY_OIL = "double11filloil";
    private final static String D11_CHECK1 = "DoublE11Chk11XX";
    private final static String D11_CHECK2 = "DoublE11Chk22XX";
    private final static String D11_CHECK3 = "Dou33E11Chk22XX";

    /**
     * 获取简单MD5值
     * @param data
     * @return
     */
    public static String simpleStringMD5(String data) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] inputByteArray = data.getBytes(Charset.forName("UTF-8"));
            messageDigest.update(inputByteArray);
            byte[] resultByteArray = messageDigest.digest();
            return byteArrayToHex(resultByteArray);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * 获取MD5值(加盐)
     * @param data
     * @return
     */
    public static String stringMD5(String data) {
        return Md5WithSalt(KEY, data);
    }

    /**
     * 获取预定义盐的MD5值1
     * @param itemId
     * @return
     */
    public static String checkId1(String itemId) {
        return Md5WithSalt(itemId, D11_CHECK1);
    }

    /**
     * 获取预定义盐的MD5值2
     * @param itemId
     * @return
     */
    public static String checkId2(String itemId) {
        return Md5WithSalt(itemId, D11_CHECK2);
    }

    /**
     * 获取预定义盐的MD5值3
     * @param itemId
     * @return
     */
    public static String checkId3(String itemId) {
        return Md5WithSalt(itemId, D11_CHECK3);
    }

    /**
     * 获取自定义盐的MD5值
     * @param data
     * @param customSalt
     * @return
     */
    public static String customMD5(String data, String customSalt){
        return Md5WithSalt(data, customSalt);
    }

    /**
     *
     * @param oid
     * @param cid
     * @return
     */
    public static String md5Oil(Long oid,Long cid) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            String data = oid + KEY_OIL + cid;
            byte[] inputByteArray = data.getBytes(Charset.forName("UTF-8"));
            messageDigest.update(inputByteArray);
            byte[] resultByteArray = messageDigest.digest();
            return byteArrayToHex(resultByteArray);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * 获取加盐MD5
     * @param data
     * @param salt
     * @return
     */
    private static String Md5WithSalt(String data, String salt){
        data = salt + data;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] inputByteArray = data.getBytes(Charset.forName("UTF-8"));
            messageDigest.update(inputByteArray);
            byte[] resultByteArray = messageDigest.digest();
            return byteArrayToHex(resultByteArray);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    /**
     * 字节数组转16进制
     * @param byteArray
     * @return
     */
    private static String byteArrayToHex(byte[] byteArray) {
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'a','b','c','d','e','f' };
        char[] resultCharArray =new char[byteArray.length * 2];
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b& 0xf];
        }
        return new String(resultCharArray);
    }
    public static void main(String[] args) {
        System.out.println(MD5Util.checkId3("hello1234"));
        System.out.println(MD5Util.checkId2("hello1234"));
        System.out.println(MD5Util.checkId1("hello1234"));
        System.out.println(MD5Util.stringMD5("hello1234"));
        System.out.println(MD5Util.md5Oil(10L,11L));
    }
}
