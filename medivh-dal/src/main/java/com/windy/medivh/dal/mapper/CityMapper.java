package com.windy.medivh.dal.mapper;

import com.windy.medivh.dal.model.CityDO;
import com.windy.medivh.dal.query.CityQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * MyBatis Mapper for City.
 */
 @Mapper
 @Repository
public interface CityMapper {
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
    int insertSelective(CityDO record);

    /**
     * select by query condition.
     */
    List<CityDO> selectByQuery(CityQuery query);

    /**
     * select by primary key.
     */
    CityDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") CityDO record, @Param("query") CityQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") CityDO record, @Param("query") CityQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(CityDO record);
}