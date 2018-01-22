package com.windy.medivh.dal.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class FpContractDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * fp_contract.contract_id
     */
    private Long contractId;

    /**
     * 模板id
     * fp_contract.contract_template_id
     */
    private Long contractTemplateId;

    /**
     * 合同pdf
     * fp_contract.pdf_file_id
     */
    private Long pdfFileId;

    /**
     * 1可用0不可用
     * fp_contract.status
     */
    private Integer status;

    /**
     * 创建时间
     * fp_contract.gmt_create
     */
    private Date gmtCreate;

    /**
     * 
     * fp_contract.gmt_modified
     */
    private Date gmtModified;

    /**
     * 合同html
     * fp_contract.html_file_id
     */
    private Long htmlFileId;

}