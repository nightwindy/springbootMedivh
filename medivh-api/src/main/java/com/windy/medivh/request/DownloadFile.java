package com.windy.medivh.request;

import java.io.Serializable;
import java.util.List;

public class DownloadFile implements Serializable{
    private final String dirName;
    private final List<Long> fileIds;

    public DownloadFile(String dirName, List<Long> fileIds) {
        this.dirName = dirName;
        this.fileIds = fileIds;
    }

    public String getDirName() {
        return dirName;
    }

    public List<Long> getFileIds() {
        return fileIds;
    }

    @Override
    public String toString() {
        return "DownloadFile{" +
                "dirName='" + dirName + '\'' +
                ", fileIds=" + fileIds +
                '}';
    }
}
