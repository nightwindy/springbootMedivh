package com.windy.medivh.dal.manager.impl;

import com.windy.medivh.common.query.PageResult;
import com.windy.medivh.dal.model.FpOverdueSolveDO;
import com.windy.medivh.dal.query.FpOverdueSolveQuery;
import com.windy.medivh.dal.mapper.ext.FpOverdueSolveExtMapper;
import com.windy.medivh.dal.manager.FpOverdueSolveManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for FpOverdueSolve.
 */

@Component
public class FpOverdueSolveManagerImpl implements FpOverdueSolveManager{

    
    @Autowired
    protected FpOverdueSolveExtMapper fpOverdueSolveExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(FpOverdueSolveQuery query){
        return fpOverdueSolveExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(FpOverdueSolveQuery query){
        return fpOverdueSolveExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(FpOverdueSolveDO record){
        return fpOverdueSolveExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(FpOverdueSolveDO record){
        return fpOverdueSolveExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<FpOverdueSolveDO> selectByQuery(FpOverdueSolveQuery query){
        return fpOverdueSolveExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<FpOverdueSolveDO> selectByQueryWithPage(FpOverdueSolveQuery query) {
        PageResult<FpOverdueSolveDO> result = new PageResult<FpOverdueSolveDO>();
        result.setPageSize(query.getPageSize());
        result.setPageNo(query.getPageNo());
        result.setTotalCount(this.countByQuery(query));
        result.setResult(this.selectByQuery(query));
        return result;
    }

    /**
     * select by primary key.
     */
    @Override
    public FpOverdueSolveDO selectByPrimaryKey(String id){
        return fpOverdueSolveExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( FpOverdueSolveDO record,  FpOverdueSolveQuery query){
        return fpOverdueSolveExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( FpOverdueSolveDO record,  FpOverdueSolveQuery query){

        return fpOverdueSolveExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(FpOverdueSolveDO record){
        return fpOverdueSolveExtMapper.updateByPrimaryKeySelective(record);
    }
}