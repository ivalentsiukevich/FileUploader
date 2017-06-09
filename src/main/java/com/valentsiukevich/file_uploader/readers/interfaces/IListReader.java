package com.valentsiukevich.file_uploader.readers.interfaces;

import com.valentsiukevich.file_uploader.models.DataFile;

import java.util.ArrayList;

/**
 * @author ilya_valentsiukevich
 * @version 1.0
 */
public interface IListReader {
    /**
     * Reading the list of files
     *
     * @param fileName
     * @return
     */
    ArrayList<DataFile> read(String fileName);
}
