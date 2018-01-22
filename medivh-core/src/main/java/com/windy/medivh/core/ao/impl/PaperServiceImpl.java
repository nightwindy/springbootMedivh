package com.windy.medivh.core.ao.impl;

import com.windy.medivh.common.util.SnowFlake;
import com.windy.medivh.core.ao.PaperService;
import com.windy.medivh.core.model.AddPaperCommand;
import com.windy.medivh.core.model.Paper;
import com.windy.medivh.dal.manager.FpMaterialFileManager;
import com.windy.medivh.dal.model.FpMaterialFileDO;
import com.windy.medivh.dal.query.FpMaterialFileQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private FpMaterialFileManager manager;

    @Autowired
    private SnowFlake snowFlake;

    @Override
    public FpMaterialFileDO findBy(Long fileId) {
        Assert.notNull(fileId);
        return manager.selectByPrimaryKey(fileId);
    }

    @Override
    public FpMaterialFileDO findWithNoContentBy(Long id) {
        Assert.notNull(id);
        return null;
    }

    @Override
    public List<FpMaterialFileDO> findBy(List<Long> ids) {
        Assert.notNull(ids);
        Assert.isTrue(ids.size() > 0);
        FpMaterialFileQuery fpMaterialFileQuery=new FpMaterialFileQuery();
        FpMaterialFileQuery.Criteria criteria = fpMaterialFileQuery.createCriteria();
        criteria.andFileIdIn(ids);
        return manager.selectByQuery(fpMaterialFileQuery);
    }

    @Override
    public void remove(Long fileId) {
        Assert.notNull(fileId);
        FpMaterialFileDO fpMaterialFileDO=new FpMaterialFileDO();
        fpMaterialFileDO.setFileId(fileId);
        manager.deleteByPrimaryKey(fpMaterialFileDO);
    }

    @Override
    public Long add(AddPaperCommand command) throws Exception {
        Assert.notNull(command);
        Long fileId = snowFlake.nextId();
        manager.insertSelective(new FpMaterialFileDO(fileId, command.getPath(), command.getContent(), command.getMime(), 0));
        return fileId;
    }
}
