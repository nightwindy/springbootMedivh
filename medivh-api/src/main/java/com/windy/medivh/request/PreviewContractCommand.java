package com.windy.medivh.request;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PreviewContractCommand implements Serializable {
    private final Long contractTemplateID;
    private final Map<String, Object> params;


    public PreviewContractCommand(Long contractTemplateID) {
        this.contractTemplateID = contractTemplateID;
        this.params = new HashMap<>();
    }

    public PreviewContractCommand(Long contractTemplateID, Map<String, Object> params) {
        this.contractTemplateID = contractTemplateID;
        this.params = params;
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
                '}';
    }
}
