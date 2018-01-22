package com.windy.medivh.core.model;


/**
 * Created by alex on 17/2/20.
 */
public class AddContractTemplateCommand {
    private final String name;
    private final Long fileId;
    private final Long signKind;

    public AddContractTemplateCommand(String name, Long fileId, Long signKind) {
        this.name = name;
        this.fileId = fileId;
        this.signKind = signKind;
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
}
