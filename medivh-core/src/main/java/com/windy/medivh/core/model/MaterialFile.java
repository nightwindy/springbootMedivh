package com.windy.medivh.core.model;

import java.util.Arrays;

public class MaterialFile {

    private final Long id;

    private final String path;

    private final byte[] content;

    private final String mime;

    public MaterialFile(Long id, String path, byte[] content, String mime) {
        this.id = id;
        this.path = path;
        this.content = content;
        this.mime = mime;
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

    @Override
    public String toString() {
        return "MaterialFile{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", content=" + Arrays.toString(content) +
                ", mime='" + mime + '\'' +
                '}';
    }

}
