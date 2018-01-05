package com.windy.medivh.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.NameFilter;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by XianGuo
 * Date: 2017-07-13 16:48
 * json工具
 */
public class JsonUtil {

    public static final int HUMP_MODE = 0;  // key 采用驼峰命名方式
    public static final int UNDERLINE_MODE = 1; // key 采用下划线命名方式

    /**
     * 对象转化成JsonObject
     * 驼峰命名转化成下划线
     *
     * @param mode {@link #HUMP_MODE} or {@link #UNDERLINE_MODE}
     */
    public static JSONObject parseJsonObject(Object object, int mode) {
        if (object == null) return null;
        String jsonStr = JSONObject.toJSONString(object, getNameFilter(mode));
        return JSONObject.parseObject(jsonStr);
    }

    /**
     * 数组装化成JsonArray
     * 驼峰命名转化成下划线
     *
     * @param mode {@link #HUMP_MODE} or {@link #UNDERLINE_MODE}
     */
    public static JSONArray parseJsonArray(Collection<?> collection, int mode) {
        if (CollectionUtils.isEmpty(collection)) return null;
        String jsonStr = JSONObject.toJSONString(collection, getNameFilter(mode));
        return JSONObject.parseArray(jsonStr);
    }

    /**
     * 获取json字符串
     *
     * @param mode {@link #HUMP_MODE} or {@link #UNDERLINE_MODE}
     */
    public static String getJsonStr(Object json, int mode) {
        if (json == null) {
            return null;
        }
        return JSONObject.toJSONString(json, getNameFilter(mode));
    }

    /**
     * 获取json字符串（驼峰命名）
     */
    public static String getHumpJsonStr(Object json) {
        return getJsonStr(json, HUMP_MODE);
    }

    /**
     * 获取json字符串（驼峰命名）
     */
    public static String getUnderlineJsonStr(JSONObject json) {
        return getJsonStr(json, UNDERLINE_MODE);
    }

    /**
     * JsonObject转化成对象
     */
    public static <T> T parseObject(JSONObject json, Class<T> tClass) {
        if (json == null) {
            return null;
        }
        return JSONObject.parseObject(getHumpJsonStr(json),tClass);
    }

    /**
     * JsonArray转化成List
     */
    public static <T> List<T> parseList(JSONArray jsonArr, Class<T> tClass){
        if(jsonArr==null){
            return null;
        }
        return JSONArray.parseArray(getHumpJsonStr(jsonArr),tClass);
    }


    public static NameFilter getNameFilter(int mode) {
        switch (mode) {
            case HUMP_MODE:
                return new HumpNameFilter();
            case UNDERLINE_MODE:
                return new UnderlineNameFilter();
            default:
                return new HumpNameFilter();
        }
    }

    public static class UnderlineNameFilter implements NameFilter {

        @Override
        public String process(Object o, String str, Object o1) {
            if (str == null || "".equals(str.trim())) return "";
            String regexStr = "[A-Z]";
            Matcher matcher = Pattern.compile(regexStr).matcher(str);
            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                String g = matcher.group();
                matcher.appendReplacement(sb, "_" + g.toLowerCase());
            }
            matcher.appendTail(sb);
            if (sb.charAt(0) == '_') {
                sb.delete(0, 1);
            }
            return sb.toString();
        }
    }

    public static class HumpNameFilter implements NameFilter {

        @Override
        public String process(Object o, String str, Object o1) {
            if (str == null || "".equals(str.trim())
                    || !str.contains("_")) {
                return str;
            }
            Pattern pattern = Pattern.compile("[_]\\w");
            String camel = str.toLowerCase();
            Matcher matcher = pattern.matcher(camel);
            while (matcher.find()) {
                String w = matcher.group().trim();
                camel = camel.replace(w, w.toUpperCase().replace("_", ""));
            }
            return camel;
        }
    }

    public static void main(String[] args) {

    }
}
