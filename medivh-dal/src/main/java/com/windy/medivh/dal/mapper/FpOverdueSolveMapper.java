package com.windy.medivh.dal.mapper;

import com.windy.medivh.dal.model.FpOverdueSolveDO;
import com.windy.medivh.dal.query.FpOverdueSolveQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * MyBatis Mapper for FpOverdueSolve.
 */
 @Mapper
 @Repository
public interface FpOverdueSolveMapper {
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
    int insertSelective(FpOverdueSolveDO record);

    /**
     * select by query condition.
     */
    List<FpOverdueSolveDO> selectByQuery(FpOverdueSolveQuery query);

    /**
     * select by primary key.
     */
    FpOverdueSolveDO selectByPrimaryKey(String id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") FpOverdueSolveDO record, @Param("query") FpOverdueSolveQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") FpOverdueSolveDO record, @Param("query") FpOverdueSolveQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(FpOverdueSolveDO record);
}