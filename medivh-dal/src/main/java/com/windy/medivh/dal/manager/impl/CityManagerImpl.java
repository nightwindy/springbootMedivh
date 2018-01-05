package com.windy.medivh.dal.manager.impl;

import com.windy.medivh.common.query.PageResult;
import com.windy.medivh.dal.model.CityDO;
import com.windy.medivh.dal.query.CityQuery;
import com.windy.medivh.dal.mapper.ext.CityExtMapper;
import com.windy.medivh.dal.manager.CityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Manager for City.
 */

@Component
public class CityManagerImpl implements CityManager{

    
    @Autowired
    protected CityExtMapper cityExtMapper;
    /**
     * query count by query condition.
     */
    @Override
    public int countByQuery(CityQuery query){
        return cityExtMapper.countByQuery(query);
    }

    /**
     * delete by query condition.
     */
    @Override
    public int deleteByQuery(CityQuery query){
        return cityExtMapper.deleteByQuery(query);
    }

    /**
     * delete by primary key.
     */
    @Override
    public int deleteByPrimaryKey(CityDO record){
        return cityExtMapper.deleteByPrimaryKey(record);
    }

    /**
     * insert selective.
     */
    @Override
    public long insertSelective(CityDO record){
        return cityExtMapper.insertSelective(record);
    }

    /**
     * select by query condition.
     */
    @Override
    public List<CityDO> selectByQuery(CityQuery query){
        return cityExtMapper.selectByQuery(query);
    }

    /**
     * select by query condition with page.
    */
    @Override
    public PageResult<CityDO> selectByQueryWithPage(CityQuery query) {
        PageResult<CityDO> result = new PageResult<CityDO>();
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
    public CityDO selectByPrimaryKey(Long id){
        return cityExtMapper.selectByPrimaryKey(id);
    }

    /**
     * update by query condition selective.
     */
    @Override
    public int updateByQuerySelective( CityDO record,  CityQuery query){
        return cityExtMapper.updateByQuerySelective(record,  query);
    }

    /**
     * update by query condition.
     */
    @Override
    public int updateByQuery( CityDO record,  CityQuery query){

        return cityExtMapper.updateByQuery(record, query);
    }

    /**
     * update by primary key selective.
     */
    @Override
    public int updateByPrimaryKeySelective(CityDO record){
        return cityExtMapper.updateByPrimaryKeySelective(record);
    }
}