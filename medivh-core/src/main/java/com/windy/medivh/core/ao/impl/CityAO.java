package com.windy.medivh.core.ao.impl;

import com.windy.medivh.common.entity.BizResult;
import com.windy.medivh.core.ao.ICityAO;
import com.windy.medivh.core.factory.UniqueNumberFactory;
import com.windy.medivh.dal.manager.CityManager;
import com.windy.medivh.dal.model.CityDO;
import com.windy.medivh.dal.query.CityQuery;
import com.windy.medivh.request.CityRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;


@Service
public class CityAO implements ICityAO {


    @Autowired
    private UniqueNumberFactory uniqueNumberFactory;

    @Autowired
    private CityManager cityManager;


    @Override
    public BizResult<String> insertCity(CityRequest cityRequest) {
        BizResult<String> bizResult = new BizResult<>();

        if (cityRequest.getId() != null && cityRequest.getId() != 0) {
            bizResult.setSuccess(false);
            bizResult.setMessage("cityId不能为空");
            return bizResult;
        }
        CityQuery query = new CityQuery();
        CityQuery.Criteria criteria = query.createCriteria();
        criteria.andIdEqualTo(1L);
        List<CityDO> resultList = cityManager.selectByQuery(query);
        if (CollectionUtils.isEmpty(resultList)) {
            bizResult.setSuccess(false);
            bizResult.setMessage("已有对应记录");
            return bizResult;
        }

        CityDO fpDebtDO = new CityDO();
        BeanUtils.copyProperties(cityRequest,fpDebtDO);
        cityManager.insertSelective(fpDebtDO);
        //可優化 作為主鍵使用
        String todoId = uniqueNumberFactory.getPrefixNumber(UniqueNumberFactory.DEBT_COLLECTION_PREFIX);
        bizResult.setData(todoId);
        bizResult.setSuccess(true);
        return bizResult;
    }
}
