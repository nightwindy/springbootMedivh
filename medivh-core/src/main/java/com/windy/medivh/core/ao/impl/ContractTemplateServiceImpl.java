package com.windy.medivh.core.ao.impl;

import com.windy.medivh.common.util.SnowFlake;
import com.windy.medivh.core.ao.ContractTemplateService;
import com.windy.medivh.core.model.AddContractTemplateCommand;
import com.windy.medivh.core.model.AlterContractTemplateCommand;
import com.windy.medivh.core.model.ContractTemplate;
import com.windy.medivh.dal.manager.FpContractManager;
import com.windy.medivh.dal.manager.FpContractTemplateManager;
import com.windy.medivh.dal.model.FpContractTemplateDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.IOException;

@Service
public class ContractTemplateServiceImpl implements ContractTemplateService {

    @Autowired
    private FpContractTemplateManager manager;

    @Autowired
    private SnowFlake snowFlake;

    @Override
    public void add(AddContractTemplateCommand command) throws Exception {
        Assert.notNull(command, "入参不能为null");
        FpContractTemplateDO fpContractTemplateDO=new FpContractTemplateDO(snowFlake.nextId(), command.getName(), command.getFileId(), command.getSignKind());
        manager.insertSelective(fpContractTemplateDO);
    }

    @Override
    public void remove(Long templateID) {
        Assert.notNull(templateID, "templateID 不能为null");
        /*ContractTemplate template = manager.findBy(templateID);
        manager.remove(template);*/
    }

    @Override
    public void alter(AlterContractTemplateCommand command) throws IOException {
        Assert.notNull(command);

//        ContractTemplate template = manager.findBy(command.getId());
//        Assert.notNull(template, "要修改的合同模板不存在！");

        Integer version = command.getCurrentVersion() + 1;
       /* ContractTemplate newTemplate = new ContractTemplate(command.getId(), command.getName(), version, command.getFileId(), command.getSignKind());
        manager.alter(newTemplate);*/
    }

    @Override
    public FpContractTemplateDO findBy(Long id) {
        Assert.notNull(id);
        return manager.selectByPrimaryKey(id);
    }
}
