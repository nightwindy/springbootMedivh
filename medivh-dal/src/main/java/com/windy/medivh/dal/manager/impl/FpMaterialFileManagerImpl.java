package com.windy.medivh.dal.manager.impl;

import com.windy.medivh.common.query.PageResult;
import com.windy.medivh.dal.model.FpMaterialFileDO;
import com.windy.medivh.dal.query.FpMaterialFileQuery;
import com.windy.medivh.dal.mapper.ext.FpMaterialFileExtMapper;
import com.windy.medivh.dal.manager.FpMaterialFileManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for FpMaterialFile.
 */

@Component
public class FpMaterialFileManagerImpl implements FpMaterialFileManager{

    
    @Autowired
    protected FpMaterialFileExtMapper fpMaterialFileExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(FpMaterialFileQuery query){
        return fpMaterialFileExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(FpMaterialFileQuery query){
        return fpMaterialFileExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(FpMaterialFileDO record){
        return fpMaterialFileExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(FpMaterialFileDO record){
        return fpMaterialFileExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<FpMaterialFileDO> selectByQuery(FpMaterialFileQuery query){
        return fpMaterialFileExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<FpMaterialFileDO> selectByQueryWithPage(FpMaterialFileQuery query) {
        PageResult<FpMaterialFileDO> result = new PageResult<FpMaterialFileDO>();
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
    public FpMaterialFileDO selectByPrimaryKey(Long id){
        return fpMaterialFileExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( FpMaterialFileDO record,  FpMaterialFileQuery query){
        return fpMaterialFileExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( FpMaterialFileDO record,  FpMaterialFileQuery query){

        return fpMaterialFileExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(FpMaterialFileDO record){
        return fpMaterialFileExtMapper.updateByPrimaryKeySelective(record);
    }
}