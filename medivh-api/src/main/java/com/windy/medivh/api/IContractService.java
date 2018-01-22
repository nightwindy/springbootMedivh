package com.windy.medivh.api;


import com.windy.medivh.common.entity.BizResult;
import com.windy.medivh.request.CreateContractCommand;

import java.util.HashMap;
import java.util.List;

public interface IContractService {

    /**
     * 创建合同
     * @param command
     * @return
     */
    BizResult<Long> create(CreateContractCommand command);

    /**
     * 批量创建合同
     * @param commands
     * @return
     */
    BizResult<HashMap<String,HashMap<String,Object>>> createAll(List<CreateContractCommand> commands);
    /**
     * 获取合同内容的PDF形式展示的可访问URL
     * @param contractId
     * @return
     */
    BizResult<String> findPdfPath(Long contractId);

    /**
     * 获取html形式的合同内容
     * @param contractId
     * @return
     */
    BizResult<String> findHtml(Long contractId);



    
}
