package com.windy.medivh.core.model;

/**
 * Created by alex on 17/2/22.
 */
public class AddContractCommand {
    private final Long contractTemplateId;
    private final Long pdfFileId;
    private final Long htmlFileId;

    public AddContractCommand(Long contractTemplateId, Long pdfFileId, Long htmlFileId) {
        this.contractTemplateId = contractTemplateId;
        this.pdfFileId = pdfFileId;
        this.htmlFileId = htmlFileId;
    }

    public Long getContractTemplateId() {
        return contractTemplateId;
    }

    public Long getPdfFileId() {
        return pdfFileId;
    }

    public Long getHtmlFileId() {
        return htmlFileId;
    }
}
