package com.windy.medivh.core.model;

public class Seal {

    private final Long sealId;
    private final String accountId;
    private final String sealData;

    @Deprecated
    public Seal(String accountId, String sealData) {
        this.sealId = 0l;
        this.accountId = accountId;
        this.sealData = sealData;
    }

    public Seal(Long sealId, String accountId, String sealData) {
        this.sealId = sealId;
        this.accountId = accountId;
        this.sealData = sealData;
    }

    public Long getSealId() {
        return sealId;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getSealData() {
        return sealData;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", sealData='" + sealData + '\'' +
                '}';
    }
}
