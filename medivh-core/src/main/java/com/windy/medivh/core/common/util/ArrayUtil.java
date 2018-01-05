package com.windy.medivh.core.common.util;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ArrayUtil {

    private static final Integer DEFAULT_PAGE_SIZE = 100;

    /**
     * 对数组进行分页
     *
     * @param pageSize     分页大小
     * @param list         数组
     * @param pageListener 回调接口
     */
    public static <T> void onPage(List<T> list, int pageSize, PageListener<T> pageListener) {

        if (list == null || list.size() == 0 || pageListener == null) {
            return;
        }
        int length = list.size();
        int mode = length % pageSize; // 余数
        int pageNo = length / pageSize + (mode == 0 ? 0 : 1); // 页数
        for (int i = 0; i < pageNo; i++) {
            List<T> tempList;
            if (i == pageNo - 1) {
                tempList = list.subList(i * pageSize, length);// 最后一页
            } else {
                tempList = list.subList(i * pageSize, (i + 1) * pageSize);
            }
            if(pageListener.onPage(tempList)){
                // 如果返回true直接中断
                break;
            }
        }
    }

    /**
     * 对数组进行分页
     *
     * @param list         数组
     * @param pageListener 回调接口
     * @param <T>
     */
    public static <T> void onPage(List<T> list, PageListener<T> pageListener) {
        onPage(list, DEFAULT_PAGE_SIZE, pageListener);
    }

    public interface PageListener<T> {
        boolean onPage(List<T> pageList);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add("编号：" + i);
        }


        List<String> tempList = new ArrayList<>();
        onPage(list,11, new PageListener<String>() {
            @Override
            public boolean onPage(List<String> pageList) {
                tempList.addAll(pageList);
                return false;
            }
        });

        System.out.println(JSON.toJSONString(tempList));

    }
}
