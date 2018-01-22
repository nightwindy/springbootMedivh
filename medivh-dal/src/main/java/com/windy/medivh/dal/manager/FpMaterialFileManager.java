package com.windy.medivh.dal.manager;

import com.windy.medivh.common.query.PageResult;
import com.windy.medivh.dal.model.FpMaterialFileDO;
import com.windy.medivh.dal.query.FpMaterialFileQuery;

import java.util.List;


/**
 * Manager for FpMaterialFile.
 */
public interface FpMaterialFileManager {
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
    long insertSelective(FpMaterialFileDO record);

    /**
     * select by query condition.
     */
    List<FpMaterialFileDO> selectByQuery(FpMaterialFileQuery query);


    /**
     * select by query condition with page.
     */
    PageResult<FpMaterialFileDO> selectByQueryWithPage(FpMaterialFileQuery query);

    /**
     * select by primary key.
     */
    FpMaterialFileDO selectByPrimaryKey(Long id);

    /**
     * update by query condition selective.
     */
    int updateByQuerySelective( FpMaterialFileDO record,  FpMaterialFileQuery query);

    /**
     * update by query condition.
     */
    int updateByQuery(FpMaterialFileDO record, FpMaterialFileQuery query);

    /**
     * update by primary key selective.
     */
    int updateByPrimaryKeySelective(FpMaterialFileDO record);
}