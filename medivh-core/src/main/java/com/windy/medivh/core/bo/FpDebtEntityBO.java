package com.windy.medivh.core.bo;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Data
public class FpDebtEntityBO {
    private String debtId;
    private String orderNo;
    private String contractNo;
    private String chargeNo;
    private String dealerNo;
    private String dealerName;
    private String capitalNo;
    private String capitalName;
    private byte bizType;
    private byte currency;
    private BigDecimal loanAmount;
    private byte status;
    private Timestamp expenditureDate;
    private Timestamp dueDate;
    private Timestamp realDueDate;
    private Byte limitType;
    private Long limitCount;
    private BigDecimal standardRate;
    private String floatType;
    private BigDecimal floatCount;
    private BigDecimal realityRate;
    private BigDecimal serviceTariffing;
    private BigDecimal serviceCharge;
    private String interestAccruaType;
    private String interestPeriod;
    private String repaymentType;
    private String mainGuarantyStyle;
    private String guarantyStyle;
    private BigDecimal assureAmount;
    private BigDecimal assureRatio;
    private BigDecimal fairValue;
    private BigDecimal riskExposureBase;
    private BigDecimal riskExposureExpert;
    private String debtUse;
    private Byte exhibitionCount;
    private Long exhibitionDaytime;
    private BigDecimal overduePrincipal;
    private BigDecimal overdueInterest;
    private BigDecimal overduePrincipalAndInterest;
    private Timestamp overdueTime;
    private Long overdueDaytime;
    private Long addDebtPeriods;
    private String pyatyiClassifyResult;
    private Long continuousDebtCount;
    private Byte finalType;
    private Timestamp finalDate;
    private Timestamp classifyDate;
    private String classifyOperator;
    private Timestamp interestSettlementDate;
    private String interestSettlementType;
    private BigDecimal debtSumInterest;
    private BigDecimal debtSumDefaultInterest;
    private BigDecimal debtSumCompoundInterest;
    private BigDecimal debtSumInterestAndPrincipal;
    private BigDecimal privilegePrice;
    private BigDecimal capticalSumInterest;
    private BigDecimal capticalSumInterestAndPrincipal;
    private BigDecimal debtBalanceAndPrincipal;
    private BigDecimal debtBalanceInterest;
    private BigDecimal debtBalanceDefaultInterest;
    private BigDecimal debtBalanceCompoundInterest;
    private BigDecimal debtBalanceInterestAndPrincipal;
    private Timestamp examineDate;
    private String initialManageOrganization;
    private String initialManager;
    private String nowManageOrganization;
    private String nowManager;
    private String businessArea;
    private String businessBusiness;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String memo;
    private Byte hasCheckArrvailTime;
    private Long arrivalTime;
    private Byte operateStatus;

}