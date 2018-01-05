package com.windy.medivh.core.common.util;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanUtil {

    /**
     * 将对象转化成map
     *
     * @param bean
     * @return
     */
    public static HashMap<String, Object> toMap(Object bean) {

        HashMap<String, Object> result = new HashMap<>(10);
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(bean, SerializerFeature.WriteMapNullValue));
        for (Map.Entry entry : jsonObject.entrySet()) {
            if (entry != null) {
                result.put(entry.getKey().toString(), entry.getValue());
            }
        }

        return result;
    }

    public static <T,V> List<V> copyPorp2DOs(Class<V> destClaz, List<T> obis) throws RuntimeException {
        try {
            if(CollectionUtils.isEmpty(obis)){
                return null;
            }
            List<V> list = Lists.newArrayList();
            V destObj = null;
            for (Object obi : obis) {
                destObj = destClaz.newInstance();
                BeanUtils.copyProperties(obi, destObj);
                list.add(destObj);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException("Copy prop error.", e);
        }
    }

    public static <T,V> List<V> copyPorp2DOs(Class<V> destClaz, List<T> obis, IConvert<V,T> iConvert) throws RuntimeException {
        try {
            if(CollectionUtils.isEmpty(obis)){
                return null;
            }
            List<V> list = Lists.newArrayList();
            V destObj = null;
            for (T obi : obis) {
                destObj = destClaz.newInstance();
                BeanUtils.copyProperties(obi, destObj);
                iConvert.convert(destObj,obi);
                list.add(destObj);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException("Copy prop error.", e);
        }
    }

    //对批量复制的特殊字段做处理
    public interface IConvert<V, T> {
        void convert(V v,T t);
    }

}
