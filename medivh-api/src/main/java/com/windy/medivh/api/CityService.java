package com.windy.medivh.api;

import com.windy.medivh.common.entity.BizResult;
import com.windy.medivh.request.CityRequest;


public interface CityService {

    BizResult<String> insertCity(CityRequest cityRequest);

}
