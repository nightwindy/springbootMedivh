package com.windy.medivh.core.model;

/**
 * Created by alex on 17/2/20.
 */
public class AlterContractTemplateCommand {
    private final Long id;
    private final String name;
    private final Long fileId;
    private final Long signKind;
    private final Integer currentVersion;

    public AlterContractTemplateCommand(Long id, String name, Long fileId, Long signKind, Integer currentVersion) {
        this.id = id;
        this.name = name;
        this.fileId = fileId;
        this.signKind = signKind;
        this.currentVersion = currentVersion;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getFileId() {
        return fileId;
    }

    public Long getSignKind() {
        return signKind;
    }

    public Integer getCurrentVersion() {
        return currentVersion;
    }
}
