package com.windy.medivh.dal.manager.impl;

import com.windy.medivh.common.query.PageResult;
import com.windy.medivh.dal.model.FpContractDO;
import com.windy.medivh.dal.query.FpContractQuery;
import com.windy.medivh.dal.mapper.ext.FpContractExtMapper;
import com.windy.medivh.dal.manager.FpContractManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for FpContract.
 */

@Component
public class FpContractManagerImpl implements FpContractManager{

    
    @Autowired
    protected FpContractExtMapper fpContractExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(FpContractQuery query){
        return fpContractExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(FpContractQuery query){
        return fpContractExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(FpContractDO record){
        return fpContractExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(FpContractDO record){
        return fpContractExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<FpContractDO> selectByQuery(FpContractQuery query){
        return fpContractExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<FpContractDO> selectByQueryWithPage(FpContractQuery query) {
        PageResult<FpContractDO> result = new PageResult<FpContractDO>();
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
    public FpContractDO selectByPrimaryKey(Long id){
        return fpContractExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( FpContractDO record,  FpContractQuery query){
        return fpContractExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( FpContractDO record,  FpContractQuery query){

        return fpContractExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(FpContractDO record){
        return fpContractExtMapper.updateByPrimaryKeySelective(record);
    }
}