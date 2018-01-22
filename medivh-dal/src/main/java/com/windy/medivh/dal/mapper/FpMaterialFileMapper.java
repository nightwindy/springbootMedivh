package com.windy.medivh.dal.mapper;

import com.windy.medivh.dal.model.FpMaterialFileDO;
import com.windy.medivh.dal.query.FpMaterialFileQuery;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * MyBatis Mapper for FpMaterialFile.
 */
 @Mapper
 @Repository
public interface FpMaterialFileMapper {
    /**
     * query count by query condition.
     */
    int countByQuery(FpMaterialFileQuery query);

    /**
     * delete by query condition.
     */
    int deleteByQuery(FpMaterialFileQuery query);

    /**
     * delete by primary key.
     */
    int deleteByPrimaryKey(FpMaterialFileDO record);

    /**
     * insert selective.
     */
    int insertSelective(FpMaterialFileDO record);

    /**
     * select by query condition.
     */
    List<FpMaterialFileDO> selectByQuery(FpMaterialFileQuery query);

    /**
     * select by primary key.
     */
    FpMaterialFileDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective(@Param("record") FpMaterialFileDO record, @Param("query") FpMaterialFileQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(@Param("record") FpMaterialFileDO record, @Param("query") FpMaterialFileQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(FpMaterialFileDO record);
}