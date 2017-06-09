package com.valentsiukevich.file_uploader.models;

import com.valentsiukevich.file_uploader.models.interfaces.IDownloader;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;

/**
 * File uploader from the network via HTTP protocol
 *
 * @author ilya_valentsiukevich
 * @version 1.0.0
 */
public class Downloader implements IDownloader {
    @Override
    public boolean downloadFile(DataFile file) {
        try {
            URL url = new URL(file.getUrl());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(file.getSavePath() + file.getName());

            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = bufferedInputStream.read(buffer, 0, 1024)) != -1) {
                fileOutputStream.write(buffer, 0, count);
            }

            fileOutputStream.close();
            bufferedInputStream.close();
            System.out.println("Файл " + file.toString() + " успешно загружен!!!");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean downloadFiles(ArrayList<DataFile> dataFiles, String savePath) {
        try {
            for (DataFile file : dataFiles) {
                file.setSavePath(savePath);
                downloadFile(file);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
