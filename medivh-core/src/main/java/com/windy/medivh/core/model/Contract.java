package com.windy.medivh.core.model;


public class Contract {
    private final Long id;
    private final Long contractTemplateID;
    private final Long pdfFileId;
    private final Long htmlFileId;

    public Contract(Long id, Long contractTemplateID, Long pdfFileId, Long htmlFileId) {
        this.id = id;
        this.contractTemplateID = contractTemplateID;
        this.pdfFileId = pdfFileId;
        this.htmlFileId = htmlFileId;
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

    public Long getHtmlFileId() {
        return htmlFileId;
    }
}
