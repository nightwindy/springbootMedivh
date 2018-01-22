package com.windy.medivh.request;

import java.io.Serializable;
import java.util.Map;


public class CreateContractCommand implements Serializable {
    private final Long contractTemplateID;//合同模板id
    private String orderNo;//订单号码
    private final Map<String, Object> params;//配置vm参数

    public CreateContractCommand(Long contractTemplateID, Map<String, Object> params) {
        this.contractTemplateID = contractTemplateID;
        this.params = params;
    }
    public CreateContractCommand(Long contractTemplateID, String orderNo, Map<String, Object> params) {
        this.contractTemplateID = contractTemplateID;
        this.orderNo = orderNo;
        this.params = params;
    }
    public String getOrderNo() {
        return orderNo;
    }

    public Long getContractTemplateID() {
        return contractTemplateID;
    }


    public Map<String, Object> getParams() {
        return params;
    }

    @Override
    public String toString() {
        return "CreateContractCommand{" +
                "contractTemplateID=" + contractTemplateID +
                ", params=" + params +
                ", orderNo=" + orderNo +
                '}';
    }
}
