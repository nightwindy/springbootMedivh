package com.windy.medivh.dal.mapper;

import com.windy.medivh.dal.model.FpContractTemplateDO;
import com.windy.medivh.dal.query.FpContractTemplateQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * MyBatis Mapper for FpContractTemplate.
 */
 @Mapper
 @Repository
public interface FpContractTemplateMapper {
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
    int insertSelective(FpContractTemplateDO record);

    /**
     * select by query condition.
     */
    List<FpContractTemplateDO> selectByQuery(FpContractTemplateQuery query);

    /**
     * select by primary key.
     */
    FpContractTemplateDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") FpContractTemplateDO record, @Param("query") FpContractTemplateQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") FpContractTemplateDO record, @Param("query") FpContractTemplateQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(FpContractTemplateDO record);
}