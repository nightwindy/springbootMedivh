package com.windy.medivh.dal.manager.impl;

import com.windy.medivh.common.query.PageResult;
import com.windy.medivh.dal.model.FpContractTemplateDO;
import com.windy.medivh.dal.query.FpContractTemplateQuery;
import com.windy.medivh.dal.mapper.ext.FpContractTemplateExtMapper;
import com.windy.medivh.dal.manager.FpContractTemplateManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for FpContractTemplate.
 */

@Component
public class FpContractTemplateManagerImpl implements FpContractTemplateManager{

    
    @Autowired
    protected FpContractTemplateExtMapper fpContractTemplateExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(FpContractTemplateQuery query){
        return fpContractTemplateExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(FpContractTemplateQuery query){
        return fpContractTemplateExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(FpContractTemplateDO record){
        return fpContractTemplateExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(FpContractTemplateDO record){
        return fpContractTemplateExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<FpContractTemplateDO> selectByQuery(FpContractTemplateQuery query){
        return fpContractTemplateExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<FpContractTemplateDO> selectByQueryWithPage(FpContractTemplateQuery query) {
        PageResult<FpContractTemplateDO> result = new PageResult<FpContractTemplateDO>();
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
    public FpContractTemplateDO selectByPrimaryKey(Long id){
        return fpContractTemplateExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( FpContractTemplateDO record,  FpContractTemplateQuery query){
        return fpContractTemplateExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( FpContractTemplateDO record,  FpContractTemplateQuery query){

        return fpContractTemplateExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(FpContractTemplateDO record){
        return fpContractTemplateExtMapper.updateByPrimaryKeySelective(record);
    }
}