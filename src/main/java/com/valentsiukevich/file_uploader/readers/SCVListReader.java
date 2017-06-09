package com.valentsiukevich.file_uploader.readers;

import com.valentsiukevich.file_uploader.models.DataFile;
import com.valentsiukevich.file_uploader.readers.interfaces.IListReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author ilya_valentsiukevich
 * @version 1.0.0
 */
public class SCVListReader implements IListReader {
    @Override
    public ArrayList<DataFile> read(String fileName) {
        ArrayList<DataFile> dataFiles = new ArrayList<>();
        BufferedReader bufferedReader = null;
        String line = "";
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] file = line.split(",");

                DataFile dataFile = new DataFile();
                dataFile.setUrl(file[0]);
                dataFile.setName(file[1]);

                dataFiles.add(dataFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return dataFiles;
    }
}
