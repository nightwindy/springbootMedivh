package com.windy.medivh.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alex on 16/9/28.
 */
public class UrlParam {

    private static String SEP = "&";
    private static String PARA_SEP = "=";

    public static Map<String, String> toMap(String params) throws IllegalArgumentException {
        Assert.isTrue(StringUtils.isNotEmpty(params));
        try {

            String[] paramArr = params.split(SEP);

            Map<String, String> map = new HashMap<String, String>();

            for (String para : paramArr) {
                String[] kv = para.split(PARA_SEP);
                map.put(kv[0], kv[1]);
            }

            return map;
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String fromMap(Map<String, String> params) throws IllegalArgumentException {

        assert (params != null);
        assert (params.size() != 0);

        try {
            StringBuffer buffer = new StringBuffer();
            for (Map.Entry<String, String> param : params.entrySet()) {
                buffer.append(String.format("%s=%s&", param.getKey(), param.getValue()));
            }
            return buffer.substring(0, buffer.length() - 1);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}
