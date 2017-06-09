package com.valentsiukevich.file_uploader.models.interfaces;

import com.valentsiukevich.file_uploader.models.DataFile;

import java.util.ArrayList;

/**
 * @author ilya_valentsiukevich
 * @version 1.0.0
 */
public interface IDownloader {
    /**
     * Downloading a file from the network using the HTTP protocol
     *
     * @param file
     */
    public boolean downloadFile(DataFile file);

    /**
     * Downloading files from the network using the HTTP protocol
     *
     * @param dataFiles
     */
    public boolean downloadFiles(ArrayList<DataFile> dataFiles, String savePath);
}