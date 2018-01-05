package com.windy.medivh.core.common.util;

import org.apache.commons.beanutils.BeanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by windy on 2017/8/14.
 */
public class ConvertUtils {
    public static <T> T convertMap2Bean(Map map, Class T) throws Exception {
        if(map==null || map.size()==0){
            return null;
        }
        BeanInfo beanInfo = Introspector.getBeanInfo(T);
        T bean = (T)T.newInstance();
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0, n = propertyDescriptors.length; i <n ; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (map.containsKey(propertyName)) {
                Object value = map.get(propertyName);
                //这个方法不会报参数类型不匹配的错误。
                BeanUtils.copyProperty(bean, propertyName, value);
            }
        }
        return bean;
    }
    public static <T> List<T> convertListMap2ListBean(List<Map<String,Object>> listMap, Class T) throws Exception {
        List<T> beanList = new ArrayList<T>();
        for(int i=0, n=listMap.size(); i<n; i++){
            Map<String,Object> map = listMap.get(i);
            T bean = convertMap2Bean(map,T);
            beanList.add(bean);
        }
        return beanList;
    }
}
