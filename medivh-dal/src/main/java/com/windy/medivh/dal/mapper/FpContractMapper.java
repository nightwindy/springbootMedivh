package com.windy.medivh.dal.mapper;

import com.windy.medivh.dal.model.FpContractDO;
import com.windy.medivh.dal.query.FpContractQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * MyBatis Mapper for FpContract.
 */
 @Mapper
 @Repository
public interface FpContractMapper {
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
    int insertSelective(FpContractDO record);

    /**
     * select by query condition.
     */
    List<FpContractDO> selectByQuery(FpContractQuery query);

    /**
     * select by primary key.
     */
    FpContractDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") FpContractDO record, @Param("query") FpContractQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") FpContractDO record, @Param("query") FpContractQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(FpContractDO record);
}