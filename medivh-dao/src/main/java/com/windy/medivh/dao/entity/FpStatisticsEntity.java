package com.windy.medivh.dao.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by xiaotian on 2017/6/27.
 */
@Entity
@Table(name = "fp_statistics", schema = "fp_asset", catalog = "")
@DynamicInsert
@DynamicUpdate
public class FpStatisticsEntity {
    private String statisticsId;
    private Timestamp date;
    private String capitalNo;
    private String capitalName;
    private Byte productType;
    private BigDecimal currentApplyAmountSum;
    private BigDecimal currentLoanAmountSum;
    private BigDecimal depositAmountSum;
    private BigDecimal carAmountSum;
    private BigDecimal currentTakeoutAmountSum;
    private BigDecimal currentReturnAmountSum;
    private BigDecimal accumulateLoanAmountSum;
    private BigDecimal accumulateReturnPrincipalSum;
    private BigDecimal accumulateReturnInterestSum;
    private Integer carNum;

    @Id
    @Column(name = "statistics_id")
    public String getStatisticsId() {
        return statisticsId;
    }

    public void setStatisticsId(String statisticsId) {
        this.statisticsId = statisticsId;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "capital_no")
    public String getCapitalNo() {
        return capitalNo;
    }

    public void setCapitalNo(String capitalNo) {
        this.capitalNo = capitalNo;
    }

    @Basic
    @Column(name = "capital_name")
    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    @Basic
    @Column(name = "product_type")
    public Byte getProductType() {
        return productType;
    }

    public void setProductType(Byte productType) {
        this.productType = productType;
    }

    @Basic
    @Column(name = "current_apply_amount_sum")
    public BigDecimal getCurrentApplyAmountSum() {
        return currentApplyAmountSum;
    }

    public void setCurrentApplyAmountSum(BigDecimal currentApplyAmountSum) {
        this.currentApplyAmountSum = currentApplyAmountSum;
    }

    @Basic
    @Column(name = "current_loan_amount_sum")
    public BigDecimal getCurrentLoanAmountSum() {
        return currentLoanAmountSum;
    }

    public void setCurrentLoanAmountSum(BigDecimal currentLoanAmountSum) {
        this.currentLoanAmountSum = currentLoanAmountSum;
    }

    @Basic
    @Column(name = "deposit_amount_sum")
    public BigDecimal getDepositAmountSum() {
        return depositAmountSum;
    }

    public void setDepositAmountSum(BigDecimal depositAmountSum) {
        this.depositAmountSum = depositAmountSum;
    }

    @Basic
    @Column(name = "car_amount_sum")
    public BigDecimal getCarAmountSum() {
        return carAmountSum;
    }

    public void setCarAmountSum(BigDecimal carAmountSum) {
        this.carAmountSum = carAmountSum;
    }

    @Basic
    @Column(name = "current_takeout_amount_sum")
    public BigDecimal getCurrentTakeoutAmountSum() {
        return currentTakeoutAmountSum;
    }

    public void setCurrentTakeoutAmountSum(BigDecimal currentTakeoutAmountSum) {
        this.currentTakeoutAmountSum = currentTakeoutAmountSum;
    }

    @Basic
    @Column(name = "current_return_amount_sum")
    public BigDecimal getCurrentReturnAmountSum() {
        return currentReturnAmountSum;
    }

    public void setCurrentReturnAmountSum(BigDecimal currentReturnAmountSum) {
        this.currentReturnAmountSum = currentReturnAmountSum;
    }

    @Basic
    @Column(name = "accumulate_loan_amount_sum")
    public BigDecimal getAccumulateLoanAmountSum() {
        return accumulateLoanAmountSum;
    }

    public void setAccumulateLoanAmountSum(BigDecimal accumulateLoanAmountSum) {
        this.accumulateLoanAmountSum = accumulateLoanAmountSum;
    }

    @Basic
    @Column(name = "accumulate_return_principal_sum")
    public BigDecimal getAccumulateReturnPrincipalSum() {
        return accumulateReturnPrincipalSum;
    }

    public void setAccumulateReturnPrincipalSum(BigDecimal accumulateReturnPrincipalSum) {
        this.accumulateReturnPrincipalSum = accumulateReturnPrincipalSum;
    }

    @Basic
    @Column(name = "accumulate_return_interest_sum")
    public BigDecimal getAccumulateReturnInterestSum() {
        return accumulateReturnInterestSum;
    }

    public void setAccumulateReturnInterestSum(BigDecimal accumulateReturnInterestSum) {
        this.accumulateReturnInterestSum = accumulateReturnInterestSum;
    }

    @Basic
    @Column(name = "car_num")
    public Integer getCarNum() {
        return carNum;
    }
    public void setCarNum(Integer carNum) {
        this.carNum = carNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FpStatisticsEntity that = (FpStatisticsEntity) o;

        if (statisticsId != null ? !statisticsId.equals(that.statisticsId) : that.statisticsId != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (capitalNo != null ? !capitalNo.equals(that.capitalNo) : that.capitalNo != null) return false;
        if (capitalName != null ? !capitalName.equals(that.capitalName) : that.capitalName != null) return false;
        if (productType != null ? !productType.equals(that.productType) : that.productType != null) return false;
        if (currentApplyAmountSum != null ? !currentApplyAmountSum.equals(that.currentApplyAmountSum) : that.currentApplyAmountSum != null)
            return false;
        if (currentLoanAmountSum != null ? !currentLoanAmountSum.equals(that.currentLoanAmountSum) : that.currentLoanAmountSum != null)
            return false;
        if (depositAmountSum != null ? !depositAmountSum.equals(that.depositAmountSum) : that.depositAmountSum != null)
            return false;
        if (carAmountSum != null ? !carAmountSum.equals(that.carAmountSum) : that.carAmountSum != null) return false;
        if (currentTakeoutAmountSum != null ? !currentTakeoutAmountSum.equals(that.currentTakeoutAmountSum) : that.currentTakeoutAmountSum != null)
            return false;
        if (currentReturnAmountSum != null ? !currentReturnAmountSum.equals(that.currentReturnAmountSum) : that.currentReturnAmountSum != null)
            return false;
        if (accumulateLoanAmountSum != null ? !accumulateLoanAmountSum.equals(that.accumulateLoanAmountSum) : that.accumulateLoanAmountSum != null)
            return false;
        if (accumulateReturnPrincipalSum != null ? !accumulateReturnPrincipalSum.equals(that.accumulateReturnPrincipalSum) : that.accumulateReturnPrincipalSum != null)
            return false;
        if (accumulateReturnInterestSum != null ? !accumulateReturnInterestSum.equals(that.accumulateReturnInterestSum) : that.accumulateReturnInterestSum != null)
            return false;
        return carNum != null ? carNum.equals(that.carNum) : that.carNum == null;
    }

    @Override
    public int hashCode() {
        int result = statisticsId != null ? statisticsId.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (capitalNo != null ? capitalNo.hashCode() : 0);
        result = 31 * result + (capitalName != null ? capitalName.hashCode() : 0);
        result = 31 * result + (productType != null ? productType.hashCode() : 0);
        result = 31 * result + (currentApplyAmountSum != null ? currentApplyAmountSum.hashCode() : 0);
        result = 31 * result + (currentLoanAmountSum != null ? currentLoanAmountSum.hashCode() : 0);
        result = 31 * result + (depositAmountSum != null ? depositAmountSum.hashCode() : 0);
        result = 31 * result + (carAmountSum != null ? carAmountSum.hashCode() : 0);
        result = 31 * result + (currentTakeoutAmountSum != null ? currentTakeoutAmountSum.hashCode() : 0);
        result = 31 * result + (currentReturnAmountSum != null ? currentReturnAmountSum.hashCode() : 0);
        result = 31 * result + (accumulateLoanAmountSum != null ? accumulateLoanAmountSum.hashCode() : 0);
        result = 31 * result + (accumulateReturnPrincipalSum != null ? accumulateReturnPrincipalSum.hashCode() : 0);
        result = 31 * result + (accumulateReturnInterestSum != null ? accumulateReturnInterestSum.hashCode() : 0);
        result = 31 * result + (carNum != null ? carNum.hashCode() : 0);
        return result;
    }
}
