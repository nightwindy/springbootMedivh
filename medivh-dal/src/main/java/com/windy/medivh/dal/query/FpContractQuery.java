package com.windy.medivh.dal.query;


import com.windy.medivh.common.query.BaseCriteria;
import com.windy.medivh.common.query.BaseQuery;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

public class FpContractQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    public FpContractQuery() {
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
     * This class corresponds to the database table fp_contract
     */
         protected abstract static class GeneratedCriteria extends BaseCriteria {

        protected GeneratedCriteria() {
            super();
        }

        public Criteria andContractIdIsNull() {
            addCriterion("contract_id is null");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNotNull() {
            addCriterion("contract_id is not null");
            return (Criteria) this;
        }

        public Criteria andContractIdEqualTo(Long value) {
            addCriterion("contract_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andContractIdNotEqualTo(Long value) {
            addCriterion("contract_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria anContractIdGreaterThan(Long value) {
            addCriterion("contract_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThanOrEqualTo(Long value) {
            addCriterion("contract_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThan(Long value) {
            addCriterion("contract_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThanOrEqualTo(Long value) {
            addCriterion("contract_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andContractIdIn(List<Long> values) {
            addCriterion("contract_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andContractIdNotIn(List<Long> values) {
            addCriterion("contract_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andContractIdBetween(Long value1, Long value2) {
            addCriterion("contract_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andContractIdNotBetween(Long value1, Long value2) {
            addCriterion("contract_id not between", value1, value2, "id");
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

        public Criteria andContractTemplateIdIsNull() {
            addCriterion("contract_template_id is null");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdIsNotNull() {
            addCriterion("contract_template_id is not null");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdEqualTo(Long value) {
            addCriterion("contract_template_id =", value, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdNotEqualTo(Long value) {
            addCriterion("contract_template_id <>", value, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdGreaterThan(Long value) {
            addCriterion("contract_template_id >", value, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("contract_template_id >=", value, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdLessThan(Long value) {
            addCriterion("contract_template_id <", value, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdLessThanOrEqualTo(Long value) {
            addCriterion("contract_template_id <=", value, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdLike(Long value) {
            addCriterion("contract_template_id like", value, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdNotLike(Long value) {
            addCriterion("contract_template_id not like", value, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdIn(List<Long> values) {
            addCriterion("contract_template_id in", values, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdNotIn(List<Long> values) {
            addCriterion("contract_template_id not in", values, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdBetween(Long value1, Long value2) {
            addCriterion("contract_template_id between", value1, value2, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andContractTemplateIdNotBetween(Long value1, Long value2) {
            addCriterion("contract_template_id not between", value1, value2, "contractTemplateId");
            return (Criteria) this;
        }

        public Criteria andPdfFileIdIsNull() {
            addCriterion("pdf_file_id is null");
            return (Criteria) this;
        }

        public Criteria andPdfFileIdIsNotNull() {
            addCriterion("pdf_file_id is not null");
            return (Criteria) this;
        }

        public Criteria andPdfFileIdEqualTo(Long value) {
            addCriterion("pdf_file_id =", value, "pdfFileId");
            return (Criteria) this;
        }

        public Criteria andPdfFileIdNotEqualTo(Long value) {
            addCriterion("pdf_file_id <>", value, "pdfFileId");
            return (Criteria) this;
        }

        public Criteria andPdfFileIdGreaterThan(Long value) {
            addCriterion("pdf_file_id >", value, "pdfFileId");
            return (Criteria) this;
        }

        public Criteria andPdfFileIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pdf_file_id >=", value, "pdfFileId");
            return (Criteria) this;
        }

        public Criteria andPdfFileIdLessThan(Long value) {
            addCriterion("pdf_file_id <", value, "pdfFileId");
            return (Criteria) this;
        }

        public Criteria andPdfFileIdLessThanOrEqualTo(Long value) {
            addCriterion("pdf_file_id <=", value, "pdfFileId");
            return (Criteria) this;
        }

        public Criteria andPdfFileIdLike(Long value) {
            addCriterion("pdf_file_id like", value, "pdfFileId");
            return (Criteria) this;
        }

        public Criteria andPdfFileIdNotLike(Long value) {
            addCriterion("pdf_file_id not like", value, "pdfFileId");
            return (Criteria) this;
        }

        public Criteria andPdfFileIdIn(List<Long> values) {
            addCriterion("pdf_file_id in", values, "pdfFileId");
            return (Criteria) this;
        }

        public Criteria andPdfFileIdNotIn(List<Long> values) {
            addCriterion("pdf_file_id not in", values, "pdfFileId");
            return (Criteria) this;
        }

        public Criteria andPdfFileIdBetween(Long value1, Long value2) {
            addCriterion("pdf_file_id between", value1, value2, "pdfFileId");
            return (Criteria) this;
        }

        public Criteria andPdfFileIdNotBetween(Long value1, Long value2) {
            addCriterion("pdf_file_id not between", value1, value2, "pdfFileId");
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

        public Criteria andHtmlFileIdIsNull() {
            addCriterion("html_file_id is null");
            return (Criteria) this;
        }

        public Criteria andHtmlFileIdIsNotNull() {
            addCriterion("html_file_id is not null");
            return (Criteria) this;
        }

        public Criteria andHtmlFileIdEqualTo(Long value) {
            addCriterion("html_file_id =", value, "htmlFileId");
            return (Criteria) this;
        }

        public Criteria andHtmlFileIdNotEqualTo(Long value) {
            addCriterion("html_file_id <>", value, "htmlFileId");
            return (Criteria) this;
        }

        public Criteria andHtmlFileIdGreaterThan(Long value) {
            addCriterion("html_file_id >", value, "htmlFileId");
            return (Criteria) this;
        }

        public Criteria andHtmlFileIdGreaterThanOrEqualTo(Long value) {
            addCriterion("html_file_id >=", value, "htmlFileId");
            return (Criteria) this;
        }

        public Criteria andHtmlFileIdLessThan(Long value) {
            addCriterion("html_file_id <", value, "htmlFileId");
            return (Criteria) this;
        }

        public Criteria andHtmlFileIdLessThanOrEqualTo(Long value) {
            addCriterion("html_file_id <=", value, "htmlFileId");
            return (Criteria) this;
        }

        public Criteria andHtmlFileIdLike(Long value) {
            addCriterion("html_file_id like", value, "htmlFileId");
            return (Criteria) this;
        }

        public Criteria andHtmlFileIdNotLike(Long value) {
            addCriterion("html_file_id not like", value, "htmlFileId");
            return (Criteria) this;
        }

        public Criteria andHtmlFileIdIn(List<Long> values) {
            addCriterion("html_file_id in", values, "htmlFileId");
            return (Criteria) this;
        }

        public Criteria andHtmlFileIdNotIn(List<Long> values) {
            addCriterion("html_file_id not in", values, "htmlFileId");
            return (Criteria) this;
        }

        public Criteria andHtmlFileIdBetween(Long value1, Long value2) {
            addCriterion("html_file_id between", value1, value2, "htmlFileId");
            return (Criteria) this;
        }

        public Criteria andHtmlFileIdNotBetween(Long value1, Long value2) {
            addCriterion("html_file_id not between", value1, value2, "htmlFileId");
            return (Criteria) this;
        }

    }

    /**
     * This class corresponds to the database table fp_contract
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