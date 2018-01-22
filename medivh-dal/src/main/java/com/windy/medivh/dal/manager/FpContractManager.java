package com.windy.medivh.dal.manager;

import com.windy.medivh.common.query.PageResult;
import com.windy.medivh.dal.model.FpContractDO;
import com.windy.medivh.dal.query.FpContractQuery;

import java.util.List;


/**
 * Manager for FpContract.
 */
public interface FpContractManager {
    /**
     * query count by query condition.
     */
    int countByQuery(FpContractQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(FpContractQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(FpContractDO record);

    /**
     * insert selective.
     */
    long insertSelective(FpContractDO record);

    /**
     * select by query condition.
     */
    List<FpContractDO> selectByQuery(FpContractQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<FpContractDO> selectByQueryWithPage(FpContractQuery query);

    /**
     * select by primary key.
     */
    FpContractDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( FpContractDO record,  FpContractQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(FpContractDO record, FpContractQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(FpContractDO record);
}