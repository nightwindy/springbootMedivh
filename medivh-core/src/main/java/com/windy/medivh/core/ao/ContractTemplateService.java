package com.windy.medivh.core.ao;

import com.windy.medivh.core.model.AddContractTemplateCommand;
import com.windy.medivh.core.model.AlterContractTemplateCommand;
import com.windy.medivh.dal.model.FpContractDO;
import com.windy.medivh.dal.model.FpContractTemplateDO;

import java.io.IOException;

public interface ContractTemplateService {

    FpContractTemplateDO findBy(Long id);

    void add(AddContractTemplateCommand template) throws Exception;

    void remove(Long templateID);

    void alter(AlterContractTemplateCommand command) throws IOException;
}