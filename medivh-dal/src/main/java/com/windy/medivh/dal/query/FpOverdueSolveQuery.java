package com.windy.medivh.dal.query;



import com.windy.medivh.common.query.BaseCriteria;
import com.windy.medivh.common.query.BaseQuery;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

public class FpOverdueSolveQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    public FpOverdueSolveQuery() {
        super();
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        super.oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This class corresponds to the database table fp_overdue_solve
     */
         protected abstract static class GeneratedCriteria extends BaseCriteria {

        protected GeneratedCriteria() {
            super();
        }

        public Criteria andOverdueSolveIdIsNull() {
            addCriterion("overdue_solve_id is null");
            return (Criteria) this;
        }

        public Criteria andOverdueSolveIdIsNotNull() {
            addCriterion("overdue_solve_id is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueSolveIdEqualTo(String value) {
            addCriterion("overdue_solve_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andOverdueSolveIdNotEqualTo(String value) {
            addCriterion("overdue_solve_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria anOverdueSolveIdGreaterThan(String value) {
            addCriterion("overdue_solve_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andOverdueSolveIdGreaterThanOrEqualTo(String value) {
            addCriterion("overdue_solve_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andOverdueSolveIdLessThan(String value) {
            addCriterion("overdue_solve_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andOverdueSolveIdLessThanOrEqualTo(String value) {
            addCriterion("overdue_solve_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andOverdueSolveIdIn(List<String> values) {
            addCriterion("overdue_solve_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andOverdueSolveIdNotIn(List<String> values) {
            addCriterion("overdue_solve_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andOverdueSolveIdBetween(String value1, String value2) {
            addCriterion("overdue_solve_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOverdueSolveIdNotBetween(String value1, String value2) {
            addCriterion("overdue_solve_id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andCollectionNoIsNull() {
            addCriterion("collection_no is null");
            return (Criteria) this;
        }

        public Criteria andCollectionNoIsNotNull() {
            addCriterion("collection_no is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionNoEqualTo(String value) {
            addCriterion("collection_no =", value, "collectionNo");
            return (Criteria) this;
        }

        public Criteria andCollectionNoNotEqualTo(String value) {
            addCriterion("collection_no <>", value, "collectionNo");
            return (Criteria) this;
        }

        public Criteria andCollectionNoGreaterThan(String value) {
            addCriterion("collection_no >", value, "collectionNo");
            return (Criteria) this;
        }

        public Criteria andCollectionNoGreaterThanOrEqualTo(String value) {
            addCriterion("collection_no >=", value, "collectionNo");
            return (Criteria) this;
        }

        public Criteria andCollectionNoLessThan(String value) {
            addCriterion("collection_no <", value, "collectionNo");
            return (Criteria) this;
        }

        public Criteria andCollectionNoLessThanOrEqualTo(String value) {
            addCriterion("collection_no <=", value, "collectionNo");
            return (Criteria) this;
        }

        public Criteria andCollectionNoLike(String value) {
            addCriterion("collection_no like", value, "collectionNo");
            return (Criteria) this;
        }

        public Criteria andCollectionNoNotLike(String value) {
            addCriterion("collection_no not like", value, "collectionNo");
            return (Criteria) this;
        }

        public Criteria andCollectionNoIn(List<String> values) {
            addCriterion("collection_no in", values, "collectionNo");
            return (Criteria) this;
        }

        public Criteria andCollectionNoNotIn(List<String> values) {
            addCriterion("collection_no not in", values, "collectionNo");
            return (Criteria) this;
        }

        public Criteria andCollectionNoBetween(String value1, String value2) {
            addCriterion("collection_no between", value1, value2, "collectionNo");
            return (Criteria) this;
        }

        public Criteria andCollectionNoNotBetween(String value1, String value2) {
            addCriterion("collection_no not between", value1, value2, "collectionNo");
            return (Criteria) this;
        }

        public Criteria andDebtIdIsNull() {
            addCriterion("debt_id is null");
            return (Criteria) this;
        }

        public Criteria andDebtIdIsNotNull() {
            addCriterion("debt_id is not null");
            return (Criteria) this;
        }

        public Criteria andDebtIdEqualTo(String value) {
            addCriterion("debt_id =", value, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdNotEqualTo(String value) {
            addCriterion("debt_id <>", value, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdGreaterThan(String value) {
            addCriterion("debt_id >", value, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdGreaterThanOrEqualTo(String value) {
            addCriterion("debt_id >=", value, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdLessThan(String value) {
            addCriterion("debt_id <", value, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdLessThanOrEqualTo(String value) {
            addCriterion("debt_id <=", value, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdLike(String value) {
            addCriterion("debt_id like", value, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdNotLike(String value) {
            addCriterion("debt_id not like", value, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdIn(List<String> values) {
            addCriterion("debt_id in", values, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdNotIn(List<String> values) {
            addCriterion("debt_id not in", values, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdBetween(String value1, String value2) {
            addCriterion("debt_id between", value1, value2, "debtId");
            return (Criteria) this;
        }

        public Criteria andDebtIdNotBetween(String value1, String value2) {
            addCriterion("debt_id not between", value1, value2, "debtId");
            return (Criteria) this;
        }

        public Criteria andExecutorIsNull() {
            addCriterion("executor is null");
            return (Criteria) this;
        }

        public Criteria andExecutorIsNotNull() {
            addCriterion("executor is not null");
            return (Criteria) this;
        }

        public Criteria andExecutorEqualTo(String value) {
            addCriterion("executor =", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorNotEqualTo(String value) {
            addCriterion("executor <>", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorGreaterThan(String value) {
            addCriterion("executor >", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorGreaterThanOrEqualTo(String value) {
            addCriterion("executor >=", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorLessThan(String value) {
            addCriterion("executor <", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorLessThanOrEqualTo(String value) {
            addCriterion("executor <=", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorLike(String value) {
            addCriterion("executor like", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorNotLike(String value) {
            addCriterion("executor not like", value, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorIn(List<String> values) {
            addCriterion("executor in", values, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorNotIn(List<String> values) {
            addCriterion("executor not in", values, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorBetween(String value1, String value2) {
            addCriterion("executor between", value1, value2, "executor");
            return (Criteria) this;
        }

        public Criteria andExecutorNotBetween(String value1, String value2) {
            addCriterion("executor not between", value1, value2, "executor");
            return (Criteria) this;
        }

        public Criteria andExecuteIdIsNull() {
            addCriterion("execute_id is null");
            return (Criteria) this;
        }

        public Criteria andExecuteIdIsNotNull() {
            addCriterion("execute_id is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteIdEqualTo(String value) {
            addCriterion("execute_id =", value, "executeId");
            return (Criteria) this;
        }

        public Criteria andExecuteIdNotEqualTo(String value) {
            addCriterion("execute_id <>", value, "executeId");
            return (Criteria) this;
        }

        public Criteria andExecuteIdGreaterThan(String value) {
            addCriterion("execute_id >", value, "executeId");
            return (Criteria) this;
        }

        public Criteria andExecuteIdGreaterThanOrEqualTo(String value) {
            addCriterion("execute_id >=", value, "executeId");
            return (Criteria) this;
        }

        public Criteria andExecuteIdLessThan(String value) {
            addCriterion("execute_id <", value, "executeId");
            return (Criteria) this;
        }

        public Criteria andExecuteIdLessThanOrEqualTo(String value) {
            addCriterion("execute_id <=", value, "executeId");
            return (Criteria) this;
        }

        public Criteria andExecuteIdLike(String value) {
            addCriterion("execute_id like", value, "executeId");
            return (Criteria) this;
        }

        public Criteria andExecuteIdNotLike(String value) {
            addCriterion("execute_id not like", value, "executeId");
            return (Criteria) this;
        }

        public Criteria andExecuteIdIn(List<String> values) {
            addCriterion("execute_id in", values, "executeId");
            return (Criteria) this;
        }

        public Criteria andExecuteIdNotIn(List<String> values) {
            addCriterion("execute_id not in", values, "executeId");
            return (Criteria) this;
        }

        public Criteria andExecuteIdBetween(String value1, String value2) {
            addCriterion("execute_id between", value1, value2, "executeId");
            return (Criteria) this;
        }

        public Criteria andExecuteIdNotBetween(String value1, String value2) {
            addCriterion("execute_id not between", value1, value2, "executeId");
            return (Criteria) this;
        }

        public Criteria andExecuteDateIsNull() {
            addCriterion("execute_date is null");
            return (Criteria) this;
        }

        public Criteria andExecuteDateIsNotNull() {
            addCriterion("execute_date is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteDateEqualTo(Date value) {
            addCriterion("execute_date =", value, "executeDate");
            return (Criteria) this;
        }

        public Criteria andExecuteDateNotEqualTo(Date value) {
            addCriterion("execute_date <>", value, "executeDate");
            return (Criteria) this;
        }

        public Criteria andExecuteDateGreaterThan(Date value) {
            addCriterion("execute_date >", value, "executeDate");
            return (Criteria) this;
        }

        public Criteria andExecuteDateGreaterThanOrEqualTo(Date value) {
            addCriterion("execute_date >=", value, "executeDate");
            return (Criteria) this;
        }

        public Criteria andExecuteDateLessThan(Date value) {
            addCriterion("execute_date <", value, "executeDate");
            return (Criteria) this;
        }

        public Criteria andExecuteDateLessThanOrEqualTo(Date value) {
            addCriterion("execute_date <=", value, "executeDate");
            return (Criteria) this;
        }

        public Criteria andExecuteDateLike(Date value) {
            addCriterion("execute_date like", value, "executeDate");
            return (Criteria) this;
        }

        public Criteria andExecuteDateNotLike(Date value) {
            addCriterion("execute_date not like", value, "executeDate");
            return (Criteria) this;
        }

        public Criteria andExecuteDateIn(List<Date> values) {
            addCriterion("execute_date in", values, "executeDate");
            return (Criteria) this;
        }

        public Criteria andExecuteDateNotIn(List<Date> values) {
            addCriterion("execute_date not in", values, "executeDate");
            return (Criteria) this;
        }

        public Criteria andExecuteDateBetween(Date value1, Date value2) {
            addCriterion("execute_date between", value1, value2, "executeDate");
            return (Criteria) this;
        }

        public Criteria andExecuteDateNotBetween(Date value1, Date value2) {
            addCriterion("execute_date not between", value1, value2, "executeDate");
            return (Criteria) this;
        }

        public Criteria andCarPositionIsNull() {
            addCriterion("car_position is null");
            return (Criteria) this;
        }

        public Criteria andCarPositionIsNotNull() {
            addCriterion("car_position is not null");
            return (Criteria) this;
        }

        public Criteria andCarPositionEqualTo(Integer value) {
            addCriterion("car_position =", value, "carPosition");
            return (Criteria) this;
        }

        public Criteria andCarPositionNotEqualTo(Integer value) {
            addCriterion("car_position <>", value, "carPosition");
            return (Criteria) this;
        }

        public Criteria andCarPositionGreaterThan(Integer value) {
            addCriterion("car_position >", value, "carPosition");
            return (Criteria) this;
        }

        public Criteria andCarPositionGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_position >=", value, "carPosition");
            return (Criteria) this;
        }

        public Criteria andCarPositionLessThan(Integer value) {
            addCriterion("car_position <", value, "carPosition");
            return (Criteria) this;
        }

        public Criteria andCarPositionLessThanOrEqualTo(Integer value) {
            addCriterion("car_position <=", value, "carPosition");
            return (Criteria) this;
        }

        public Criteria andCarPositionLike(Integer value) {
            addCriterion("car_position like", value, "carPosition");
            return (Criteria) this;
        }

        public Criteria andCarPositionNotLike(Integer value) {
            addCriterion("car_position not like", value, "carPosition");
            return (Criteria) this;
        }

        public Criteria andCarPositionIn(List<Integer> values) {
            addCriterion("car_position in", values, "carPosition");
            return (Criteria) this;
        }

        public Criteria andCarPositionNotIn(List<Integer> values) {
            addCriterion("car_position not in", values, "carPosition");
            return (Criteria) this;
        }

        public Criteria andCarPositionBetween(Integer value1, Integer value2) {
            addCriterion("car_position between", value1, value2, "carPosition");
            return (Criteria) this;
        }

        public Criteria andCarPositionNotBetween(Integer value1, Integer value2) {
            addCriterion("car_position not between", value1, value2, "carPosition");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalIsNull() {
            addCriterion("debt_principal is null");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalIsNotNull() {
            addCriterion("debt_principal is not null");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalEqualTo(java.math.BigDecimal value) {
            addCriterion("debt_principal =", value, "debtPrincipal");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalNotEqualTo(java.math.BigDecimal value) {
            addCriterion("debt_principal <>", value, "debtPrincipal");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalGreaterThan(java.math.BigDecimal value) {
            addCriterion("debt_principal >", value, "debtPrincipal");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalGreaterThanOrEqualTo(java.math.BigDecimal value) {
            addCriterion("debt_principal >=", value, "debtPrincipal");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalLessThan(java.math.BigDecimal value) {
            addCriterion("debt_principal <", value, "debtPrincipal");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalLessThanOrEqualTo(java.math.BigDecimal value) {
            addCriterion("debt_principal <=", value, "debtPrincipal");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalLike(java.math.BigDecimal value) {
            addCriterion("debt_principal like", value, "debtPrincipal");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalNotLike(java.math.BigDecimal value) {
            addCriterion("debt_principal not like", value, "debtPrincipal");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalIn(List<java.math.BigDecimal> values) {
            addCriterion("debt_principal in", values, "debtPrincipal");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalNotIn(List<java.math.BigDecimal> values) {
            addCriterion("debt_principal not in", values, "debtPrincipal");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
            addCriterion("debt_principal between", value1, value2, "debtPrincipal");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
            addCriterion("debt_principal not between", value1, value2, "debtPrincipal");
            return (Criteria) this;
        }

        public Criteria andDebtInterestIsNull() {
            addCriterion("debt_interest is null");
            return (Criteria) this;
        }

        public Criteria andDebtInterestIsNotNull() {
            addCriterion("debt_interest is not null");
            return (Criteria) this;
        }

        public Criteria andDebtInterestEqualTo(java.math.BigDecimal value) {
            addCriterion("debt_interest =", value, "debtInterest");
            return (Criteria) this;
        }

        public Criteria andDebtInterestNotEqualTo(java.math.BigDecimal value) {
            addCriterion("debt_interest <>", value, "debtInterest");
            return (Criteria) this;
        }

        public Criteria andDebtInterestGreaterThan(java.math.BigDecimal value) {
            addCriterion("debt_interest >", value, "debtInterest");
            return (Criteria) this;
        }

        public Criteria andDebtInterestGreaterThanOrEqualTo(java.math.BigDecimal value) {
            addCriterion("debt_interest >=", value, "debtInterest");
            return (Criteria) this;
        }

        public Criteria andDebtInterestLessThan(java.math.BigDecimal value) {
            addCriterion("debt_interest <", value, "debtInterest");
            return (Criteria) this;
        }

        public Criteria andDebtInterestLessThanOrEqualTo(java.math.BigDecimal value) {
            addCriterion("debt_interest <=", value, "debtInterest");
            return (Criteria) this;
        }

        public Criteria andDebtInterestLike(java.math.BigDecimal value) {
            addCriterion("debt_interest like", value, "debtInterest");
            return (Criteria) this;
        }

        public Criteria andDebtInterestNotLike(java.math.BigDecimal value) {
            addCriterion("debt_interest not like", value, "debtInterest");
            return (Criteria) this;
        }

        public Criteria andDebtInterestIn(List<java.math.BigDecimal> values) {
            addCriterion("debt_interest in", values, "debtInterest");
            return (Criteria) this;
        }

        public Criteria andDebtInterestNotIn(List<java.math.BigDecimal> values) {
            addCriterion("debt_interest not in", values, "debtInterest");
            return (Criteria) this;
        }

        public Criteria andDebtInterestBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
            addCriterion("debt_interest between", value1, value2, "debtInterest");
            return (Criteria) this;
        }

        public Criteria andDebtInterestNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
            addCriterion("debt_interest not between", value1, value2, "debtInterest");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalInterestIsNull() {
            addCriterion("debt_principal_interest is null");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalInterestIsNotNull() {
            addCriterion("debt_principal_interest is not null");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalInterestEqualTo(java.math.BigDecimal value) {
            addCriterion("debt_principal_interest =", value, "debtPrincipalInterest");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalInterestNotEqualTo(java.math.BigDecimal value) {
            addCriterion("debt_principal_interest <>", value, "debtPrincipalInterest");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalInterestGreaterThan(java.math.BigDecimal value) {
            addCriterion("debt_principal_interest >", value, "debtPrincipalInterest");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalInterestGreaterThanOrEqualTo(java.math.BigDecimal value) {
            addCriterion("debt_principal_interest >=", value, "debtPrincipalInterest");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalInterestLessThan(java.math.BigDecimal value) {
            addCriterion("debt_principal_interest <", value, "debtPrincipalInterest");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalInterestLessThanOrEqualTo(java.math.BigDecimal value) {
            addCriterion("debt_principal_interest <=", value, "debtPrincipalInterest");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalInterestLike(java.math.BigDecimal value) {
            addCriterion("debt_principal_interest like", value, "debtPrincipalInterest");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalInterestNotLike(java.math.BigDecimal value) {
            addCriterion("debt_principal_interest not like", value, "debtPrincipalInterest");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalInterestIn(List<java.math.BigDecimal> values) {
            addCriterion("debt_principal_interest in", values, "debtPrincipalInterest");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalInterestNotIn(List<java.math.BigDecimal> values) {
            addCriterion("debt_principal_interest not in", values, "debtPrincipalInterest");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalInterestBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
            addCriterion("debt_principal_interest between", value1, value2, "debtPrincipalInterest");
            return (Criteria) this;
        }

        public Criteria andDebtPrincipalInterestNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
            addCriterion("debt_principal_interest not between", value1, value2, "debtPrincipalInterest");
            return (Criteria) this;
        }

        public Criteria andSolveSchemeIsNull() {
            addCriterion("solve_scheme is null");
            return (Criteria) this;
        }

        public Criteria andSolveSchemeIsNotNull() {
            addCriterion("solve_scheme is not null");
            return (Criteria) this;
        }

        public Criteria andSolveSchemeEqualTo(Integer value) {
            addCriterion("solve_scheme =", value, "solveScheme");
            return (Criteria) this;
        }

        public Criteria andSolveSchemeNotEqualTo(Integer value) {
            addCriterion("solve_scheme <>", value, "solveScheme");
            return (Criteria) this;
        }

        public Criteria andSolveSchemeGreaterThan(Integer value) {
            addCriterion("solve_scheme >", value, "solveScheme");
            return (Criteria) this;
        }

        public Criteria andSolveSchemeGreaterThanOrEqualTo(Integer value) {
            addCriterion("solve_scheme >=", value, "solveScheme");
            return (Criteria) this;
        }

        public Criteria andSolveSchemeLessThan(Integer value) {
            addCriterion("solve_scheme <", value, "solveScheme");
            return (Criteria) this;
        }

        public Criteria andSolveSchemeLessThanOrEqualTo(Integer value) {
            addCriterion("solve_scheme <=", value, "solveScheme");
            return (Criteria) this;
        }

        public Criteria andSolveSchemeLike(Integer value) {
            addCriterion("solve_scheme like", value, "solveScheme");
            return (Criteria) this;
        }

        public Criteria andSolveSchemeNotLike(Integer value) {
            addCriterion("solve_scheme not like", value, "solveScheme");
            return (Criteria) this;
        }

        public Criteria andSolveSchemeIn(List<Integer> values) {
            addCriterion("solve_scheme in", values, "solveScheme");
            return (Criteria) this;
        }

        public Criteria andSolveSchemeNotIn(List<Integer> values) {
            addCriterion("solve_scheme not in", values, "solveScheme");
            return (Criteria) this;
        }

        public Criteria andSolveSchemeBetween(Integer value1, Integer value2) {
            addCriterion("solve_scheme between", value1, value2, "solveScheme");
            return (Criteria) this;
        }

        public Criteria andSolveSchemeNotBetween(Integer value1, Integer value2) {
            addCriterion("solve_scheme not between", value1, value2, "solveScheme");
            return (Criteria) this;
        }

        public Criteria andExecuteDescIsNull() {
            addCriterion("execute_desc is null");
            return (Criteria) this;
        }

        public Criteria andExecuteDescIsNotNull() {
            addCriterion("execute_desc is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteDescEqualTo(String value) {
            addCriterion("execute_desc =", value, "executeDesc");
            return (Criteria) this;
        }

        public Criteria andExecuteDescNotEqualTo(String value) {
            addCriterion("execute_desc <>", value, "executeDesc");
            return (Criteria) this;
        }

        public Criteria andExecuteDescGreaterThan(String value) {
            addCriterion("execute_desc >", value, "executeDesc");
            return (Criteria) this;
        }

        public Criteria andExecuteDescGreaterThanOrEqualTo(String value) {
            addCriterion("execute_desc >=", value, "executeDesc");
            return (Criteria) this;
        }

        public Criteria andExecuteDescLessThan(String value) {
            addCriterion("execute_desc <", value, "executeDesc");
            return (Criteria) this;
        }

        public Criteria andExecuteDescLessThanOrEqualTo(String value) {
            addCriterion("execute_desc <=", value, "executeDesc");
            return (Criteria) this;
        }

        public Criteria andExecuteDescLike(String value) {
            addCriterion("execute_desc like", value, "executeDesc");
            return (Criteria) this;
        }

        public Criteria andExecuteDescNotLike(String value) {
            addCriterion("execute_desc not like", value, "executeDesc");
            return (Criteria) this;
        }

        public Criteria andExecuteDescIn(List<String> values) {
            addCriterion("execute_desc in", values, "executeDesc");
            return (Criteria) this;
        }

        public Criteria andExecuteDescNotIn(List<String> values) {
            addCriterion("execute_desc not in", values, "executeDesc");
            return (Criteria) this;
        }

        public Criteria andExecuteDescBetween(String value1, String value2) {
            addCriterion("execute_desc between", value1, value2, "executeDesc");
            return (Criteria) this;
        }

        public Criteria andExecuteDescNotBetween(String value1, String value2) {
            addCriterion("execute_desc not between", value1, value2, "executeDesc");
            return (Criteria) this;
        }

        public Criteria andProcedurePositionIsNull() {
            addCriterion("procedure_position is null");
            return (Criteria) this;
        }

        public Criteria andProcedurePositionIsNotNull() {
            addCriterion("procedure_position is not null");
            return (Criteria) this;
        }

        public Criteria andProcedurePositionEqualTo(Integer value) {
            addCriterion("procedure_position =", value, "procedurePosition");
            return (Criteria) this;
        }

        public Criteria andProcedurePositionNotEqualTo(Integer value) {
            addCriterion("procedure_position <>", value, "procedurePosition");
            return (Criteria) this;
        }

        public Criteria andProcedurePositionGreaterThan(Integer value) {
            addCriterion("procedure_position >", value, "procedurePosition");
            return (Criteria) this;
        }

        public Criteria andProcedurePositionGreaterThanOrEqualTo(Integer value) {
            addCriterion("procedure_position >=", value, "procedurePosition");
            return (Criteria) this;
        }

        public Criteria andProcedurePositionLessThan(Integer value) {
            addCriterion("procedure_position <", value, "procedurePosition");
            return (Criteria) this;
        }

        public Criteria andProcedurePositionLessThanOrEqualTo(Integer value) {
            addCriterion("procedure_position <=", value, "procedurePosition");
            return (Criteria) this;
        }

        public Criteria andProcedurePositionLike(Integer value) {
            addCriterion("procedure_position like", value, "procedurePosition");
            return (Criteria) this;
        }

        public Criteria andProcedurePositionNotLike(Integer value) {
            addCriterion("procedure_position not like", value, "procedurePosition");
            return (Criteria) this;
        }

        public Criteria andProcedurePositionIn(List<Integer> values) {
            addCriterion("procedure_position in", values, "procedurePosition");
            return (Criteria) this;
        }

        public Criteria andProcedurePositionNotIn(List<Integer> values) {
            addCriterion("procedure_position not in", values, "procedurePosition");
            return (Criteria) this;
        }

        public Criteria andProcedurePositionBetween(Integer value1, Integer value2) {
            addCriterion("procedure_position between", value1, value2, "procedurePosition");
            return (Criteria) this;
        }

        public Criteria andProcedurePositionNotBetween(Integer value1, Integer value2) {
            addCriterion("procedure_position not between", value1, value2, "procedurePosition");
            return (Criteria) this;
        }

        public Criteria andPaymentInterestIsNull() {
            addCriterion("payment_interest is null");
            return (Criteria) this;
        }

        public Criteria andPaymentInterestIsNotNull() {
            addCriterion("payment_interest is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentInterestEqualTo(java.math.BigDecimal value) {
            addCriterion("payment_interest =", value, "paymentInterest");
            return (Criteria) this;
        }

        public Criteria andPaymentInterestNotEqualTo(java.math.BigDecimal value) {
            addCriterion("payment_interest <>", value, "paymentInterest");
            return (Criteria) this;
        }

        public Criteria andPaymentInterestGreaterThan(java.math.BigDecimal value) {
            addCriterion("payment_interest >", value, "paymentInterest");
            return (Criteria) this;
        }

        public Criteria andPaymentInterestGreaterThanOrEqualTo(java.math.BigDecimal value) {
            addCriterion("payment_interest >=", value, "paymentInterest");
            return (Criteria) this;
        }

        public Criteria andPaymentInterestLessThan(java.math.BigDecimal value) {
            addCriterion("payment_interest <", value, "paymentInterest");
            return (Criteria) this;
        }

        public Criteria andPaymentInterestLessThanOrEqualTo(java.math.BigDecimal value) {
            addCriterion("payment_interest <=", value, "paymentInterest");
            return (Criteria) this;
        }

        public Criteria andPaymentInterestLike(java.math.BigDecimal value) {
            addCriterion("payment_interest like", value, "paymentInterest");
            return (Criteria) this;
        }

        public Criteria andPaymentInterestNotLike(java.math.BigDecimal value) {
            addCriterion("payment_interest not like", value, "paymentInterest");
            return (Criteria) this;
        }

        public Criteria andPaymentInterestIn(List<java.math.BigDecimal> values) {
            addCriterion("payment_interest in", values, "paymentInterest");
            return (Criteria) this;
        }

        public Criteria andPaymentInterestNotIn(List<java.math.BigDecimal> values) {
            addCriterion("payment_interest not in", values, "paymentInterest");
            return (Criteria) this;
        }

        public Criteria andPaymentInterestBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
            addCriterion("payment_interest between", value1, value2, "paymentInterest");
            return (Criteria) this;
        }

        public Criteria andPaymentInterestNotBetween(java.math.BigDecimal value1, java.math.BigDecimal value2) {
            addCriterion("payment_interest not between", value1, value2, "paymentInterest");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andPredictRepaymentDateIsNull() {
            addCriterion("predict_repayment_date is null");
            return (Criteria) this;
        }

        public Criteria andPredictRepaymentDateIsNotNull() {
            addCriterion("predict_repayment_date is not null");
            return (Criteria) this;
        }

        public Criteria andPredictRepaymentDateEqualTo(Date value) {
            addCriterion("predict_repayment_date =", value, "predictRepaymentDate");
            return (Criteria) this;
        }

        public Criteria andPredictRepaymentDateNotEqualTo(Date value) {
            addCriterion("predict_repayment_date <>", value, "predictRepaymentDate");
            return (Criteria) this;
        }

        public Criteria andPredictRepaymentDateGreaterThan(Date value) {
            addCriterion("predict_repayment_date >", value, "predictRepaymentDate");
            return (Criteria) this;
        }

        public Criteria andPredictRepaymentDateGreaterThanOrEqualTo(Date value) {
            addCriterion("predict_repayment_date >=", value, "predictRepaymentDate");
            return (Criteria) this;
        }

        public Criteria andPredictRepaymentDateLessThan(Date value) {
            addCriterion("predict_repayment_date <", value, "predictRepaymentDate");
            return (Criteria) this;
        }

        public Criteria andPredictRepaymentDateLessThanOrEqualTo(Date value) {
            addCriterion("predict_repayment_date <=", value, "predictRepaymentDate");
            return (Criteria) this;
        }

        public Criteria andPredictRepaymentDateLike(Date value) {
            addCriterion("predict_repayment_date like", value, "predictRepaymentDate");
            return (Criteria) this;
        }

        public Criteria andPredictRepaymentDateNotLike(Date value) {
            addCriterion("predict_repayment_date not like", value, "predictRepaymentDate");
            return (Criteria) this;
        }

        public Criteria andPredictRepaymentDateIn(List<Date> values) {
            addCriterion("predict_repayment_date in", values, "predictRepaymentDate");
            return (Criteria) this;
        }

        public Criteria andPredictRepaymentDateNotIn(List<Date> values) {
            addCriterion("predict_repayment_date not in", values, "predictRepaymentDate");
            return (Criteria) this;
        }

        public Criteria andPredictRepaymentDateBetween(Date value1, Date value2) {
            addCriterion("predict_repayment_date between", value1, value2, "predictRepaymentDate");
            return (Criteria) this;
        }

        public Criteria andPredictRepaymentDateNotBetween(Date value1, Date value2) {
            addCriterion("predict_repayment_date not between", value1, value2, "predictRepaymentDate");
            return (Criteria) this;
        }

        public Criteria andCarStatusIsNull() {
            addCriterion("car_status is null");
            return (Criteria) this;
        }

        public Criteria andCarStatusIsNotNull() {
            addCriterion("car_status is not null");
            return (Criteria) this;
        }

        public Criteria andCarStatusEqualTo(Integer value) {
            addCriterion("car_status =", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotEqualTo(Integer value) {
            addCriterion("car_status <>", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusGreaterThan(Integer value) {
            addCriterion("car_status >", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_status >=", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusLessThan(Integer value) {
            addCriterion("car_status <", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusLessThanOrEqualTo(Integer value) {
            addCriterion("car_status <=", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusLike(Integer value) {
            addCriterion("car_status like", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotLike(Integer value) {
            addCriterion("car_status not like", value, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusIn(List<Integer> values) {
            addCriterion("car_status in", values, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotIn(List<Integer> values) {
            addCriterion("car_status not in", values, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusBetween(Integer value1, Integer value2) {
            addCriterion("car_status between", value1, value2, "carStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("car_status not between", value1, value2, "carStatus");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusIsNull() {
            addCriterion("procedure_status is null");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusIsNotNull() {
            addCriterion("procedure_status is not null");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusEqualTo(Integer value) {
            addCriterion("procedure_status =", value, "procedureStatus");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusNotEqualTo(Integer value) {
            addCriterion("procedure_status <>", value, "procedureStatus");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusGreaterThan(Integer value) {
            addCriterion("procedure_status >", value, "procedureStatus");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("procedure_status >=", value, "procedureStatus");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusLessThan(Integer value) {
            addCriterion("procedure_status <", value, "procedureStatus");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusLessThanOrEqualTo(Integer value) {
            addCriterion("procedure_status <=", value, "procedureStatus");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusLike(Integer value) {
            addCriterion("procedure_status like", value, "procedureStatus");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusNotLike(Integer value) {
            addCriterion("procedure_status not like", value, "procedureStatus");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusIn(List<Integer> values) {
            addCriterion("procedure_status in", values, "procedureStatus");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusNotIn(List<Integer> values) {
            addCriterion("procedure_status not in", values, "procedureStatus");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusBetween(Integer value1, Integer value2) {
            addCriterion("procedure_status between", value1, value2, "procedureStatus");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("procedure_status not between", value1, value2, "procedureStatus");
            return (Criteria) this;
        }

        public Criteria andCarStatusDescIsNull() {
            addCriterion("car_status_desc is null");
            return (Criteria) this;
        }

        public Criteria andCarStatusDescIsNotNull() {
            addCriterion("car_status_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCarStatusDescEqualTo(String value) {
            addCriterion("car_status_desc =", value, "carStatusDesc");
            return (Criteria) this;
        }

        public Criteria andCarStatusDescNotEqualTo(String value) {
            addCriterion("car_status_desc <>", value, "carStatusDesc");
            return (Criteria) this;
        }

        public Criteria andCarStatusDescGreaterThan(String value) {
            addCriterion("car_status_desc >", value, "carStatusDesc");
            return (Criteria) this;
        }

        public Criteria andCarStatusDescGreaterThanOrEqualTo(String value) {
            addCriterion("car_status_desc >=", value, "carStatusDesc");
            return (Criteria) this;
        }

        public Criteria andCarStatusDescLessThan(String value) {
            addCriterion("car_status_desc <", value, "carStatusDesc");
            return (Criteria) this;
        }

        public Criteria andCarStatusDescLessThanOrEqualTo(String value) {
            addCriterion("car_status_desc <=", value, "carStatusDesc");
            return (Criteria) this;
        }

        public Criteria andCarStatusDescLike(String value) {
            addCriterion("car_status_desc like", value, "carStatusDesc");
            return (Criteria) this;
        }

        public Criteria andCarStatusDescNotLike(String value) {
            addCriterion("car_status_desc not like", value, "carStatusDesc");
            return (Criteria) this;
        }

        public Criteria andCarStatusDescIn(List<String> values) {
            addCriterion("car_status_desc in", values, "carStatusDesc");
            return (Criteria) this;
        }

        public Criteria andCarStatusDescNotIn(List<String> values) {
            addCriterion("car_status_desc not in", values, "carStatusDesc");
            return (Criteria) this;
        }

        public Criteria andCarStatusDescBetween(String value1, String value2) {
            addCriterion("car_status_desc between", value1, value2, "carStatusDesc");
            return (Criteria) this;
        }

        public Criteria andCarStatusDescNotBetween(String value1, String value2) {
            addCriterion("car_status_desc not between", value1, value2, "carStatusDesc");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusDescIsNull() {
            addCriterion("procedure_status_desc is null");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusDescIsNotNull() {
            addCriterion("procedure_status_desc is not null");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusDescEqualTo(String value) {
            addCriterion("procedure_status_desc =", value, "procedureStatusDesc");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusDescNotEqualTo(String value) {
            addCriterion("procedure_status_desc <>", value, "procedureStatusDesc");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusDescGreaterThan(String value) {
            addCriterion("procedure_status_desc >", value, "procedureStatusDesc");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusDescGreaterThanOrEqualTo(String value) {
            addCriterion("procedure_status_desc >=", value, "procedureStatusDesc");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusDescLessThan(String value) {
            addCriterion("procedure_status_desc <", value, "procedureStatusDesc");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusDescLessThanOrEqualTo(String value) {
            addCriterion("procedure_status_desc <=", value, "procedureStatusDesc");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusDescLike(String value) {
            addCriterion("procedure_status_desc like", value, "procedureStatusDesc");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusDescNotLike(String value) {
            addCriterion("procedure_status_desc not like", value, "procedureStatusDesc");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusDescIn(List<String> values) {
            addCriterion("procedure_status_desc in", values, "procedureStatusDesc");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusDescNotIn(List<String> values) {
            addCriterion("procedure_status_desc not in", values, "procedureStatusDesc");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusDescBetween(String value1, String value2) {
            addCriterion("procedure_status_desc between", value1, value2, "procedureStatusDesc");
            return (Criteria) this;
        }

        public Criteria andProcedureStatusDescNotBetween(String value1, String value2) {
            addCriterion("procedure_status_desc not between", value1, value2, "procedureStatusDesc");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIsNull() {
            addCriterion("approve_status is null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIsNotNull() {
            addCriterion("approve_status is not null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusEqualTo(Integer value) {
            addCriterion("approve_status =", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotEqualTo(Integer value) {
            addCriterion("approve_status <>", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusGreaterThan(Integer value) {
            addCriterion("approve_status >", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("approve_status >=", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusLessThan(Integer value) {
            addCriterion("approve_status <", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusLessThanOrEqualTo(Integer value) {
            addCriterion("approve_status <=", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusLike(Integer value) {
            addCriterion("approve_status like", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotLike(Integer value) {
            addCriterion("approve_status not like", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIn(List<Integer> values) {
            addCriterion("approve_status in", values, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotIn(List<Integer> values) {
            addCriterion("approve_status not in", values, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusBetween(Integer value1, Integer value2) {
            addCriterion("approve_status between", value1, value2, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("approve_status not between", value1, value2, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveCommentIsNull() {
            addCriterion("approve_comment is null");
            return (Criteria) this;
        }

        public Criteria andApproveCommentIsNotNull() {
            addCriterion("approve_comment is not null");
            return (Criteria) this;
        }

        public Criteria andApproveCommentEqualTo(String value) {
            addCriterion("approve_comment =", value, "approveComment");
            return (Criteria) this;
        }

        public Criteria andApproveCommentNotEqualTo(String value) {
            addCriterion("approve_comment <>", value, "approveComment");
            return (Criteria) this;
        }

        public Criteria andApproveCommentGreaterThan(String value) {
            addCriterion("approve_comment >", value, "approveComment");
            return (Criteria) this;
        }

        public Criteria andApproveCommentGreaterThanOrEqualTo(String value) {
            addCriterion("approve_comment >=", value, "approveComment");
            return (Criteria) this;
        }

        public Criteria andApproveCommentLessThan(String value) {
            addCriterion("approve_comment <", value, "approveComment");
            return (Criteria) this;
        }

        public Criteria andApproveCommentLessThanOrEqualTo(String value) {
            addCriterion("approve_comment <=", value, "approveComment");
            return (Criteria) this;
        }

        public Criteria andApproveCommentLike(String value) {
            addCriterion("approve_comment like", value, "approveComment");
            return (Criteria) this;
        }

        public Criteria andApproveCommentNotLike(String value) {
            addCriterion("approve_comment not like", value, "approveComment");
            return (Criteria) this;
        }

        public Criteria andApproveCommentIn(List<String> values) {
            addCriterion("approve_comment in", values, "approveComment");
            return (Criteria) this;
        }

        public Criteria andApproveCommentNotIn(List<String> values) {
            addCriterion("approve_comment not in", values, "approveComment");
            return (Criteria) this;
        }

        public Criteria andApproveCommentBetween(String value1, String value2) {
            addCriterion("approve_comment between", value1, value2, "approveComment");
            return (Criteria) this;
        }

        public Criteria andApproveCommentNotBetween(String value1, String value2) {
            addCriterion("approve_comment not between", value1, value2, "approveComment");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(Integer value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(Integer value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateSourceIsNull() {
            addCriterion("create_source is null");
            return (Criteria) this;
        }

        public Criteria andCreateSourceIsNotNull() {
            addCriterion("create_source is not null");
            return (Criteria) this;
        }

        public Criteria andCreateSourceEqualTo(Integer value) {
            addCriterion("create_source =", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceNotEqualTo(Integer value) {
            addCriterion("create_source <>", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceGreaterThan(Integer value) {
            addCriterion("create_source >", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_source >=", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceLessThan(Integer value) {
            addCriterion("create_source <", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceLessThanOrEqualTo(Integer value) {
            addCriterion("create_source <=", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceLike(Integer value) {
            addCriterion("create_source like", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceNotLike(Integer value) {
            addCriterion("create_source not like", value, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceIn(List<Integer> values) {
            addCriterion("create_source in", values, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceNotIn(List<Integer> values) {
            addCriterion("create_source not in", values, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceBetween(Integer value1, Integer value2) {
            addCriterion("create_source between", value1, value2, "createSource");
            return (Criteria) this;
        }

        public Criteria andCreateSourceNotBetween(Integer value1, Integer value2) {
            addCriterion("create_source not between", value1, value2, "createSource");
            return (Criteria) this;
        }

        public Criteria andRepaymentPromiseLetterListIsNull() {
            addCriterion("repayment_promise_letter_list is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPromiseLetterListIsNotNull() {
            addCriterion("repayment_promise_letter_list is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPromiseLetterListEqualTo(String value) {
            addCriterion("repayment_promise_letter_list =", value, "repaymentPromiseLetterList");
            return (Criteria) this;
        }

        public Criteria andRepaymentPromiseLetterListNotEqualTo(String value) {
            addCriterion("repayment_promise_letter_list <>", value, "repaymentPromiseLetterList");
            return (Criteria) this;
        }

        public Criteria andRepaymentPromiseLetterListGreaterThan(String value) {
            addCriterion("repayment_promise_letter_list >", value, "repaymentPromiseLetterList");
            return (Criteria) this;
        }

        public Criteria andRepaymentPromiseLetterListGreaterThanOrEqualTo(String value) {
            addCriterion("repayment_promise_letter_list >=", value, "repaymentPromiseLetterList");
            return (Criteria) this;
        }

        public Criteria andRepaymentPromiseLetterListLessThan(String value) {
            addCriterion("repayment_promise_letter_list <", value, "repaymentPromiseLetterList");
            return (Criteria) this;
        }

        public Criteria andRepaymentPromiseLetterListLessThanOrEqualTo(String value) {
            addCriterion("repayment_promise_letter_list <=", value, "repaymentPromiseLetterList");
            return (Criteria) this;
        }

        public Criteria andRepaymentPromiseLetterListLike(String value) {
            addCriterion("repayment_promise_letter_list like", value, "repaymentPromiseLetterList");
            return (Criteria) this;
        }

        public Criteria andRepaymentPromiseLetterListNotLike(String value) {
            addCriterion("repayment_promise_letter_list not like", value, "repaymentPromiseLetterList");
            return (Criteria) this;
        }

        public Criteria andRepaymentPromiseLetterListIn(List<String> values) {
            addCriterion("repayment_promise_letter_list in", values, "repaymentPromiseLetterList");
            return (Criteria) this;
        }

        public Criteria andRepaymentPromiseLetterListNotIn(List<String> values) {
            addCriterion("repayment_promise_letter_list not in", values, "repaymentPromiseLetterList");
            return (Criteria) this;
        }

        public Criteria andRepaymentPromiseLetterListBetween(String value1, String value2) {
            addCriterion("repayment_promise_letter_list between", value1, value2, "repaymentPromiseLetterList");
            return (Criteria) this;
        }

        public Criteria andRepaymentPromiseLetterListNotBetween(String value1, String value2) {
            addCriterion("repayment_promise_letter_list not between", value1, value2, "repaymentPromiseLetterList");
            return (Criteria) this;
        }

        public Criteria andOtherFileListIsNull() {
            addCriterion("other_file_list is null");
            return (Criteria) this;
        }

        public Criteria andOtherFileListIsNotNull() {
            addCriterion("other_file_list is not null");
            return (Criteria) this;
        }

        public Criteria andOtherFileListEqualTo(String value) {
            addCriterion("other_file_list =", value, "otherFileList");
            return (Criteria) this;
        }

        public Criteria andOtherFileListNotEqualTo(String value) {
            addCriterion("other_file_list <>", value, "otherFileList");
            return (Criteria) this;
        }

        public Criteria andOtherFileListGreaterThan(String value) {
            addCriterion("other_file_list >", value, "otherFileList");
            return (Criteria) this;
        }

        public Criteria andOtherFileListGreaterThanOrEqualTo(String value) {
            addCriterion("other_file_list >=", value, "otherFileList");
            return (Criteria) this;
        }

        public Criteria andOtherFileListLessThan(String value) {
            addCriterion("other_file_list <", value, "otherFileList");
            return (Criteria) this;
        }

        public Criteria andOtherFileListLessThanOrEqualTo(String value) {
            addCriterion("other_file_list <=", value, "otherFileList");
            return (Criteria) this;
        }

        public Criteria andOtherFileListLike(String value) {
            addCriterion("other_file_list like", value, "otherFileList");
            return (Criteria) this;
        }

        public Criteria andOtherFileListNotLike(String value) {
            addCriterion("other_file_list not like", value, "otherFileList");
            return (Criteria) this;
        }

        public Criteria andOtherFileListIn(List<String> values) {
            addCriterion("other_file_list in", values, "otherFileList");
            return (Criteria) this;
        }

        public Criteria andOtherFileListNotIn(List<String> values) {
            addCriterion("other_file_list not in", values, "otherFileList");
            return (Criteria) this;
        }

        public Criteria andOtherFileListBetween(String value1, String value2) {
            addCriterion("other_file_list between", value1, value2, "otherFileList");
            return (Criteria) this;
        }

        public Criteria andOtherFileListNotBetween(String value1, String value2) {
            addCriterion("other_file_list not between", value1, value2, "otherFileList");
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table fp_overdue_solve
    */
    public  static class Criteria extends GeneratedCriteria{
        protected Criteria() {
            super();
        }
    }



    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }
}