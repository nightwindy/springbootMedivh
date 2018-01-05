package com.windy.medivh.common.util;

/**
 * 10进制转32进制;主要为全局ID服务提供字符长度压缩
 * Created by liguodong on 17/1/9.
 */
public class To32 {

    public static char[] HEX = {'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v'};

    /**
     * @param num
     * @return
     */
    public static String longToHex32(long num) {
        long t = num;
        int e = (int) (num % 32l);
        StringBuilder sb = new StringBuilder();
        while (t > 0) {
            t = num / 32l;
            e = (int) (num % 32);
            sb.append(HEX[e]);
            num = t;
        }
        return To32.invert(sb.toString());
    }

    public static String invert(String str) {
        if (str == null) {
            return "";
        }
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[chars.length - i - 1]);
        }
        return sb.toString();
    }

    public static String strToHex32(String num) {
        if (num == null) {
            return "0";
        }
        return To32.longToHex32(new Long(num));
    }

    public static void main(String[] args) {
        System.out.println(To32.longToHex32(32l * 32 * 32 + 32 + 1));
    }
}