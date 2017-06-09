package com.valentsiukevich.file_uploader.controllers;

import com.valentsiukevich.file_uploader.controllers.interfaces.IController;
import com.valentsiukevich.file_uploader.models.DataFile;
import com.valentsiukevich.file_uploader.models.Downloader;
import com.valentsiukevich.file_uploader.readers.ListReader;
import com.valentsiukevich.file_uploader.utils.Properties;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ilya_valentsiukevich
 * @version 1.0.0
 */
public class Controller implements IController {
    private Downloader downloader;

    public Controller() {
        this.downloader = new Downloader();
    }

    private void start(String url, String savePath, String nameFile) {
        DataFile dataFile = new DataFile(url, savePath, nameFile);
        downloader.downloadFile(dataFile);
    }

    private void start(String fileName, String savePath) {
        ListReader reader = new ListReader();
        ArrayList<DataFile> dataFiles = reader.read(fileName);
        downloader.downloadFiles(dataFiles, savePath);
    }

    private void start(String fileName, String savePath, int threads) {
        ExecutorService pool = Executors.newFixedThreadPool(threads);
        List<Callable<Object>> tasks = new ArrayList<>();
        try {
            ListReader reader = new ListReader();
            ArrayList<DataFile> dataFiles = reader.read(fileName);
            for (DataFile dataFile : dataFiles) {
                dataFile.setSavePath(savePath);
                tasks.add(() -> downloader.downloadFile(dataFile));
            }
            List<Future<Object>> invokeAll = pool.invokeAll(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }

    @Override
    public void start(Properties properties) {
        if (properties.getValue("-l") != null && properties.getValue("-p") != null && properties.getValue("-n") != null) {
            start(properties.getValue("-l"), properties.getValue("-p"), properties.getValue("-n"));
        } else if (properties.getValue("-f") != null && properties.getValue("-p") != null) {
            start(properties.getValue("-f"), properties.getValue("-p"));
        } else if (properties.getValue("-f") != null && properties.getValue("-p") != null && properties.getValue("-t") != null) {
            start(properties.getValue("-f"), properties.getValue("-p"), Integer.parseInt(properties.getValue("-t")));
        } else {
            System.out.println("Invalid input parameters!");
        }
    }
}
