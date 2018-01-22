package com.windy.medivh.core.model;

public class ParticipationSignWay {

    private final Long id;

    private final Boolean orderDetail;

    private final Boolean verifyCode;

    private final Long productTemplateId;

    private final Long companyId;

    private final Long companyKindId;

    public ParticipationSignWay(Long id, Boolean orderDetail, Boolean verifyCode, Long productTemplateId, Long companyId, Long companyKindId) {
        this.id = id;
        this.orderDetail = orderDetail;
        this.verifyCode = verifyCode;
        this.productTemplateId = productTemplateId;
        this.companyId = companyId;
        this.companyKindId = companyKindId;
    }

    public Long getId() {
        return id;
    }

    public Boolean getOrderDetail() {
        return orderDetail;
    }

    public Boolean getVerifyCode() {
        return verifyCode;
    }

    public Long getProductTemplateId() {
        return productTemplateId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public Long getCompanyKindId() {
        return companyKindId;
    }

    @Override
    public String toString() {
        return "ParticipationSignWay{" +
                "id=" + id +
                ", orderDetail=" + orderDetail +
                ", verifyCode=" + verifyCode +
                ", productTemplateId=" + productTemplateId +
                ", companyId=" + companyId +
                ", companyKindId=" + companyKindId +
                '}';
    }
}
