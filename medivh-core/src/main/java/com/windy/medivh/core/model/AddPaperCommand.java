package com.windy.medivh.core.model;

public class AddPaperCommand {

    private final String path;
    private final byte[] content;
    private final String mime;
    private final Boolean open;


    public AddPaperCommand(String path, byte[] content, String mime) {
        this.path = path;
        this.content = content;
        this.mime = mime;
        this.open = Boolean.FALSE;
    }

    public AddPaperCommand(String path, byte[] content, String mime, Boolean open) {
        this.path = path;
        this.content = content;
        this.mime = mime;
        this.open = open;
    }

    public String getPath() {
        return path;
    }

    public byte[] getContent() {
        return content;
    }

    public String getMime() {
        return mime;
    }

    public Boolean getOpen() {
        return open;
    }
}
