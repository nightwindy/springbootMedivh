package com.windy.medivh.dal.manager;

import com.windy.medivh.common.query.PageResult;
import com.windy.medivh.dal.model.FpContractTemplateDO;
import com.windy.medivh.dal.query.FpContractTemplateQuery;

import java.util.List;


/**
 * Manager for FpContractTemplate.
 */
public interface FpContractTemplateManager {
    /**
     * query count by query condition.
     */
    int countByQuery(FpContractTemplateQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(FpContractTemplateQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(FpContractTemplateDO record);

    /**
     * insert selective.
     */
    long insertSelective(FpContractTemplateDO record);

    /**
     * select by query condition.
     */
    List<FpContractTemplateDO> selectByQuery(FpContractTemplateQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<FpContractTemplateDO> selectByQueryWithPage(FpContractTemplateQuery query);

    /**
     * select by primary key.
     */
    FpContractTemplateDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( FpContractTemplateDO record,  FpContractTemplateQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(FpContractTemplateDO record, FpContractTemplateQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(FpContractTemplateDO record);
}