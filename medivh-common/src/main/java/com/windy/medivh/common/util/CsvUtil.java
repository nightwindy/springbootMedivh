package com.windy.medivh.common.util;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 逗号分隔值工具
 * @Author wangxiaolong <xiaolong@maihaoche.com>
 * @Date 17/6/22 下午6:06
 */
public class CsvUtil {
    private static final String COMMA_SYMBOL=",";

    private CsvUtil(){}

    /**
     * 逗号分隔值字符串转list
     * @param csvString
     * @return
     */
    public static List<String> list(String csvString){
        if(StringUtils.isEmpty(csvString)){
            return Collections.emptyList();
        }

        return new ArrayList<>(Arrays.asList(csvString.split(COMMA_SYMBOL)));
    }

    /**
     * list转逗号分隔值字符串
     * @param list
     * @return
     */
    public static String csvString(List<String> list){
        if(CollectionUtils.isEmpty(list)){
            return null;
        }

        return list.stream().collect(Collectors.joining(COMMA_SYMBOL));
    }

}
