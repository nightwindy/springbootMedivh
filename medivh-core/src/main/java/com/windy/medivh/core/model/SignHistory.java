package com.windy.medivh.core.model;

public class SignHistory {
    private final Long id;
    private final Long companyId;
    private final Integer companyKindId;
    private final Long loginUserId;
    private final Long contractId;

    public SignHistory(Long id, Long companyId, Integer companyKindId, Long loginUserId, Long contractId) {
        this.id = id;
        this.companyId = companyId;
        this.companyKindId = companyKindId;
        this.loginUserId = loginUserId;
        this.contractId = contractId;
    }

    public Long getId() {
        return id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public Integer getCompanyKindId() {
        return companyKindId;
    }

    public Long getLoginUserId() {
        return loginUserId;
    }

    public Long getContractId() {
        return contractId;
    }
}
