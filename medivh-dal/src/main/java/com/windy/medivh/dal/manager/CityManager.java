package com.windy.medivh.dal.manager;

import com.windy.medivh.common.query.PageResult;
import com.windy.medivh.dal.model.CityDO;
import com.windy.medivh.dal.query.CityQuery;

import java.util.List;


/**
 * Manager for City.
 */
public interface CityManager {
    /**
     * query count by query condition.
     */
    int countByQuery(CityQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(CityQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(CityDO record);

    /**
     * insert selective.
     */
    long insertSelective(CityDO record);

    /**
     * select by query condition.
     */
    List<CityDO> selectByQuery(CityQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<CityDO> selectByQueryWithPage(CityQuery query);

    /**
     * select by primary key.
     */
    CityDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( CityDO record,  CityQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(CityDO record, CityQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(CityDO record);
}