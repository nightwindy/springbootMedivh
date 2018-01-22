package com.windy.medivh.dal.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class FpContractTemplateDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     * fp_contract_template.template_id
     */
    private Long templateId;

    /**
     * 合同名称
     * fp_contract_template.name
     */
    private String name;

    /**
     * 版本号
     * fp_contract_template.version
     */
    private Integer version;

    /**
     * 文件ID
     * fp_contract_template.file_id
     */
    private Long fileId;

    /**
     * 合同签署类型，两方，三方，四方.etc合同对应的id
     * fp_contract_template.sign_kind_id
     */
    private Long signKindId;

    /**
     * 1可用0不可用
     * fp_contract_template.status
     */
    private Integer status;

    /**
     * 创建时间
     * fp_contract_template.gmt_create
     */
    private Date gmtCreate;

    /**
     * 
     * fp_contract_template.gmt_modified
     */
    private Date gmtModified;


    public FpContractTemplateDO(Long id, String name, Long fileId, Long signKind) {
        this.templateId = id;
        this.name = name;
        this.version = 1;
        this.fileId = fileId;
        this.signKindId = signKind;
    }
}