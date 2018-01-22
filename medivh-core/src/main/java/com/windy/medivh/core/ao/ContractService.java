package com.windy.medivh.core.ao;

import com.itextpdf.text.DocumentException;
import com.windy.medivh.core.model.AddContractCommand;
import com.windy.medivh.core.model.AlterContractCommand;
import com.windy.medivh.core.model.Contract;
import com.windy.medivh.dal.model.FpContractDO;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface ContractService {

    String createHtml(String templatePath, Map<String, Object> params);

    File createPDF(String xhtml) throws IOException, DocumentException;//根据合同模板生成合同

    Long add(AddContractCommand command) throws Exception;//新增合同

    FpContractDO findBy(Long contractId);//查询金融产品的合同，每个金融产品，只存在一份合同

    void alter(AlterContractCommand command);


}