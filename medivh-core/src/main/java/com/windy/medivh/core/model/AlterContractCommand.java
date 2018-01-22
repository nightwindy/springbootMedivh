package com.windy.medivh.core.model;

/**
 * Created by zhangweifeng on 2017/3/6.
 */
public class AlterContractCommand {
    private final Long id;
    private final Long contractTemplateID;
    private final Long pdfFileId;

    public AlterContractCommand(Long id, Long contractTemplateID, Long pdfFileId) {
        this.id = id;
        this.contractTemplateID = contractTemplateID;
        this.pdfFileId = pdfFileId;
    }

    public Long getId() {
        return id;
    }

    public Long getContractTemplateID() {
        return contractTemplateID;
    }

    public Long getPdfFileId() {
        return pdfFileId;
    }
}
