package com.windy.medivh.core.model;

public class Paper {
    private final Long id;
    private final String path;
    private final byte[] content;
    private final String mime;
    private final Boolean open;


    public Paper(Long id, String path, byte[] content, String mime, Boolean open) {
        this.id = id;
        this.path = path;
        this.content = content;
        this.mime = mime;
        this.open = open;
    }

    public Long getId() {
        return id;
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
