package com.windy.medivh.dal.manager;

import com.windy.medivh.common.query.PageResult;
import com.windy.medivh.dal.model.FpOverdueSolveDO;
import com.windy.medivh.dal.query.FpOverdueSolveQuery;

import java.util.List;


/**
 * Manager for FpOverdueSolve.
 */
public interface FpOverdueSolveManager {
    /**
     * query count by query condition.
     */
    int countByQuery(FpOverdueSolveQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(FpOverdueSolveQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(FpOverdueSolveDO record);

    /**
     * insert selective.
     */
    long insertSelective(FpOverdueSolveDO record);

    /**
     * select by query condition.
     */
    List<FpOverdueSolveDO> selectByQuery(FpOverdueSolveQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<FpOverdueSolveDO> selectByQueryWithPage(FpOverdueSolveQuery query);

    /**
     * select by primary key.
     */
    FpOverdueSolveDO selectByPrimaryKey(String id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( FpOverdueSolveDO record,  FpOverdueSolveQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(FpOverdueSolveDO record, FpOverdueSolveQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(FpOverdueSolveDO record);
}