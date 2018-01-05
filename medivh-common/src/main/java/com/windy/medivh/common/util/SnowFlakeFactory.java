package com.windy.medivh.common.util;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by alex on 2016/11/8.
 */
public class SnowFlakeFactory implements FactoryBean<SnowFlake> {

    private WorkIdGenerator workIdGenerator;

    public SnowFlakeFactory(WorkIdGenerator workIdGenerator) {
        this.workIdGenerator = workIdGenerator;
    }

    public SnowFlake getObject() throws Exception {
        Long workId = workIdGenerator.workId();
        return new SnowFlake(workId);
    }

    public Class<?> getObjectType() {
        return SnowFlake.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
