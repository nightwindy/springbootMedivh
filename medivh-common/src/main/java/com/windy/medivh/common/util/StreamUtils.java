package com.windy.medivh.common.util;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * java8 stream 工具
 * @Author wangxiaolong <xiaolong@maihaoche.com>
 * @Date 17/11/28 上午10:27
 */
public class StreamUtils {
    private StreamUtils(){}

    /**
     * 集合对象转换成Map
     * @param collection 集合对象
     * @param keyMapper key获取方式
     * @param <S> key
     * @param <T> value
     * @return
     */
    public static <S,T> Map<S,T> toMap(Collection<T> collection,Function<T,S> keyMapper){
        return toMap(collection,keyMapper,t->t);
    }

    /**
     * 对集合分组
     * @param collection
     * @param groupByKeyMapper 获取分组key的方式
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S,T> Map<S,List<T>> groupBy(Collection<T> collection,Function<T,S> groupByKeyMapper){
        return groupBy(collection,groupByKeyMapper,v->v);
    }

    /**
     * 对集合分组
     * @param collection 集合
     * @param groupByKeyMapper 获取分组key的方式
     * @param groupMembersMapper  处理组内成员的操作
     * @param <S>
     * @param <T>
     * @param <R>
     * @return
     */
    public static <S,T,R> Map<S,List<R>> groupBy(Collection<T> collection,Function<T,S> groupByKeyMapper,Function<T,R> groupMembersMapper){
        return collection.stream().filter(Objects::nonNull).collect(Collectors.groupingBy(groupByKeyMapper,Collectors.mapping(groupMembersMapper,Collectors.toList())));
    }

    /**
     * 集合对象转换成Map
     * @param collection
     * @param keyMapper
     * @param valueMapper
     * @param <S>
     * @param <T>
     * @param <R>
     * @return
     */
    public static <S,T,R> Map<S,R> toMap(Collection<T> collection,Function<T,S> keyMapper,Function<T,R> valueMapper){
        if(CollectionUtils.isEmpty(collection)){
            return Collections.emptyMap();
        }
        return collection.stream().filter(Objects::nonNull).collect(Collectors.toMap(keyMapper,valueMapper));
    }

    /**
     * 收集关键属性
     * @param collection
     * @param keyPropertyMapper
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S,T> List<S> collectKeyProperty(Collection<T> collection,Function<T,S> keyPropertyMapper){
        return convert(collection,keyPropertyMapper);
    }

    /**
     * 转换列表
     * @param collection
     * @param convertFunction
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S,T> List<S> convert(Collection<T> collection,Function<T,S> convertFunction){
        if(CollectionUtils.isEmpty(collection)){
            return Collections.emptyList();
        }
        return collection.stream().filter(Objects::nonNull).map(convertFunction).collect(Collectors.toList());
    }

}
