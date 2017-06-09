package com.valentsiukevich.file_uploader.models;

/**
 * Downloadable file
 *
 * @author ilya_valentsiukevich
 * @version 1.0.0
 */
public class DataFile {
    private String url;         // Link to file
    private String savePath;    // Path on the file system where you want to save the file
    private String name;        // File name

    public DataFile() {
        this.url = "";
        this.savePath = "";
        this.name = "";
    }

    public DataFile(String url, String savePath, String name) {
        this.url = url;
        this.savePath = savePath;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DataFile{" +
                "url='" + url + '\'' +
                ", savePath='" + savePath + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
