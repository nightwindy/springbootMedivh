package com.windy.medivh.core.ao;


import com.windy.medivh.common.entity.BizResult;
import com.windy.medivh.request.CityRequest;


public interface ICityAO {


    /**
     * 新增记录
     * @param cityRequest
     */
    BizResult<String> insertCity(CityRequest cityRequest);
}
