package com.windy.medivh.core.service.dubbo;

import com.windy.medivh.api.CityService;
import com.windy.medivh.common.entity.BizResult;
import com.windy.medivh.core.ao.impl.CityAO;
import com.windy.medivh.request.CityRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by xiaotian on 2017/7/7.
 * 超期相关的对外暴露方法
 */
@Service("cityService")
@Slf4j
public class CityImpl implements CityService {



    @Autowired
    private CityAO cityAO;


    @Override
    public BizResult<String> insertCity(CityRequest cityRequest) {
       return cityAO.insertCity(cityRequest);
    }
}
