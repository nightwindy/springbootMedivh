package com.windy.medivh.core.model;

public class ContractTemplate {

    private final Long id;
    private final String name;
    private final Integer version;
    private final Long fileId;
    private final Long signKind;


    public ContractTemplate(Long id, String name, Long fileId, Long signKind) {
        this.id = id;
        this.name = name;
        this.version = 1;
        this.fileId = fileId;
        this.signKind = signKind;
    }

    public ContractTemplate(Long id, String name, Integer version, Long fileId, Long signKind) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.fileId = fileId;
        this.signKind = signKind;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getVersion() {
        return version;
    }

    public Long getFileId() {
        return fileId;
    }

    public Long getSignKind() {
        return signKind;
    }
}
