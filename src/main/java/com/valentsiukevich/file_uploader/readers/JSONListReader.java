package com.valentsiukevich.file_uploader.readers;

import com.valentsiukevich.file_uploader.models.DataFile;
import com.valentsiukevich.file_uploader.readers.interfaces.IListReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author ilya_valentsiukevich
 * @version 1.0.0
 */
public class JSONListReader implements IListReader {
    @Override
    public ArrayList<DataFile> read(String fileName) {
        ArrayList<DataFile> dataFiles = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject) object;
            JSONArray files = (JSONArray) jsonObject.get("files");
            for (int i = 0; i < files.size(); i++) {
                JSONObject jsonObjectRow = (JSONObject) files.get(i);

                String url = (String) jsonObjectRow.get("url");
                String name = (String) jsonObjectRow.get("name");

                DataFile dataFile = new DataFile();
                dataFile.setUrl(url);
                dataFile.setName(name);

                dataFiles.add(dataFile);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataFiles;
    }
}
