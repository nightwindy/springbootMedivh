package com.windy.medivh.core.model;

public class Qualification {

    private final Long id;

    private final Long dealerId;

    private final Long qualificationTemplateId;

    private final Long fileId;

    public Qualification(Long id, Long dealerId, Long qualificationTemplateId, Long fileId) {
        this.id = id;
        this.dealerId = dealerId;
        this.qualificationTemplateId = qualificationTemplateId;
        this.fileId = fileId;
    }

    public Long getId() {
        return id;
    }

    public Long getDealerId() {
        return dealerId;
    }

    public Long getQualificationTemplateId() {
        return qualificationTemplateId;
    }

    public Long getFileId() {
        return fileId;
    }

    @Override
    public String toString() {
        return "Qualification{" +
                "id=" + id +
                ", dealerId=" + dealerId +
                ", qualificationTemplateId=" + qualificationTemplateId +
                ", fileId=" + fileId +
                '}';
    }
}
