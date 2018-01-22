package com.windy.medivh.core.ao.impl;

import com.windy.medivh.api.IContractService;
import com.windy.medivh.common.entity.BizResult;
import com.windy.medivh.core.officer.ContractOfficer;
import com.windy.medivh.request.CreateContractCommand;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;


public class IContractServiceImpl implements IContractService {

    private final Logger logger = LoggerFactory.getLogger(IContractServiceImpl.class);

    @Autowired
    private ContractOfficer contractOfficer;

    public BizResult<Long> create(CreateContractCommand command) {
        try {
            Assert.notNull(command);

            logger.info(command.toString());

            Long contractID = contractOfficer.create(command);

            return BizResult.create(contractID);
        } catch (Exception ex) {
            logger.error("创建合同失败", ex);
            return BizResult.create(0L, Boolean.FALSE, StringUtils.EMPTY, ex.getMessage());
        }
    }

    @Transactional(rollbackFor = Throwable.class)
    public BizResult<HashMap<String,HashMap<String,Object>>> createAll(List<CreateContractCommand> commands){
        try {
            Assert.notNull(commands);

            HashMap<String,HashMap<String,Object>> hashMap = new HashMap<>();
            logger.info(commands.toString());

            for (CreateContractCommand command :commands
                    ) {
                Long contractID = contractOfficer.create(command);
                HashMap<String,Object> map = new HashMap<>();
                map.put("contractId",contractID);
                map.put("templateId",command.getContractTemplateID());
                hashMap.put(command.getOrderNo(),map);

            }


            return BizResult.create(hashMap);
        } catch (Exception ex) {
            logger.error("创建合同失败", ex);
            return BizResult.create(null, Boolean.FALSE, StringUtils.EMPTY, ex.getMessage());
        }
    }



    @Override
    public BizResult<String> findHtml(Long contractId) {
        try {
            Assert.notNull(contractId);

            String xhtml = contractOfficer.findHtml(contractId);

            return BizResult.create(xhtml);
        } catch (Exception ex) {
            logger.error("查询html形式的合同失败", ex);
            return BizResult.create(StringUtils.EMPTY, Boolean.FALSE, StringUtils.EMPTY, ex.getMessage());
        }
    }


    @Override
    public BizResult<String> findPdfPath(Long contractId) {
        try {
            Assert.notNull(contractId);
            String result = contractOfficer.findPdfPath(contractId);

            return BizResult.create(result);
        } catch (Exception e) {
            logger.error("查询合同路径失败", e);
            return BizResult.create(StringUtils.EMPTY, Boolean.FALSE, StringUtils.EMPTY, e.getMessage());
        }
    }




}
