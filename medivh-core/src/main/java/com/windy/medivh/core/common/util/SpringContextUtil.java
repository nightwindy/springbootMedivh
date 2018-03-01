package com.windy.medivh.core.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

    public static Object getBean(String name){
        return ctx.getBean(name);
    }

    public static <T> T getBean(String name, Class<T> cls) {
        return ctx.getBean(name, cls);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> t){
        return ctx.getBeansOfType(t);
    }

    public static <T>  T getBean(Class<T> t){
        return ctx.getBean(t);
    }

    public static ApplicationContext getApplicationContext() {
        return ctx;
    }
}
