package com.valentsiukevich.file_uploader.readers;

import com.valentsiukevich.file_uploader.models.DataFile;
import com.valentsiukevich.file_uploader.readers.interfaces.IListReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * @author ilya_valentsiukevich
 * @version 1.0.0
 */
public class XMLListReader implements IListReader {
    @Override
    public ArrayList<DataFile> read(String fileName) {
        ArrayList<DataFile> dataFiles = new ArrayList<>();
        try {
            File xmlFile = new File(fileName);
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("file");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    DataFile dataFile = new DataFile();
                    dataFile.setUrl(element.getElementsByTagName("url").item(0).getTextContent());
                    dataFile.setName(element.getElementsByTagName("name").item(0).getTextContent());

                    dataFiles.add(dataFile);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataFiles;
    }
}
