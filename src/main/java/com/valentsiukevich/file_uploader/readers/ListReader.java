package com.valentsiukevich.file_uploader.readers;

import com.valentsiukevich.file_uploader.models.DataFile;
import com.valentsiukevich.file_uploader.readers.interfaces.IListReader;
import com.valentsiukevich.file_uploader.utils.StringUtil;

import java.util.ArrayList;

/**
 * @author ilya_valentsiukevich
 * @version 1.0.0
 */
public class ListReader implements IListReader {
    @Override
    public ArrayList<DataFile> read(String fileName) {
        String fileExtension = StringUtil.getFileExtension(fileName);
        switch (fileExtension) {
            case "csv": {
                SCVListReader scvListReader = new SCVListReader();
                return scvListReader.read(fileName);
            }
            case "xml": {
                XMLListReader xmlListReader = new XMLListReader();
                return xmlListReader.read(fileName);
            }
            case "json": {
                JSONListReader jsonListReader = new JSONListReader();
                return jsonListReader.read(fileName);
            }
        }
        return null;
    }
}
