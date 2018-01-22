package com.windy.medivh.core.model;

public class ContractKeyWordConfig {

    private final Long id;

    private final Long contractTemplateId;

    private final Integer companyKindId;

    private final String keyWord;

    public ContractKeyWordConfig(Long id, Long contractTemplateId, Integer companyKindId, String keyWord) {
        this.id = id;
        this.contractTemplateId = contractTemplateId;
        this.companyKindId = companyKindId;
        this.keyWord = keyWord;
    }

    public Long getId() {
        return id;
    }

    public Long getContractTemplateId() {
        return contractTemplateId;
    }

    public Integer getCompanyKindId() {
        return companyKindId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    @Override
    public String toString() {
        return "ContractKeyWordConfig{" +
                "id=" + id +
                ", contractTemplateId=" + contractTemplateId +
                ", companyKindId=" + companyKindId +
                ", keyWord='" + keyWord + '\'' +
                '}';
    }
}
