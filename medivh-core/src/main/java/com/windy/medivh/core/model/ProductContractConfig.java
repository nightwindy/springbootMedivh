package com.windy.medivh.core.model;

public class ProductContractConfig {

    private final Long id;

    private final Long productTemplateId;

    private final Long contractTemplateId;

    private final Long companyId;

    private final Long companyKindId;

    public ProductContractConfig(Long id, Long productTemplateId, Long contractTemplateId, Long companyId, Long companyKindId) {
        this.id = id;
        this.productTemplateId = productTemplateId;
        this.contractTemplateId = contractTemplateId;
        this.companyId = companyId;
        this.companyKindId = companyKindId;
    }

    public Long getId() {
        return id;
    }

    public Long getProductTemplateId() {
        return productTemplateId;
    }

    public Long getContractTemplateId() {
        return contractTemplateId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public Long getCompanyKindId() {
        return companyKindId;
    }

    @Override
    public String toString() {
        return "ProductContractConfig{" +
                "id=" + id +
                ", productTemplateId=" + productTemplateId +
                ", contractTemplateId=" + contractTemplateId +
                ", companyId=" + companyId +
                ", companyKindId=" + companyKindId +
                '}';
    }
}
