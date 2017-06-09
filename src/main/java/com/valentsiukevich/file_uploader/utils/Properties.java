package com.valentsiukevich.file_uploader.utils;

import java.util.ArrayList;

/**
 * @author ilya_valentsiukevicj
 * @version 1.0.0
 */
public class Properties {
    private ArrayList<Property> properties;
    private int size;

    public Properties(String[] args) {
        this.properties = StringUtil.getProperties(args);
        this.size = properties.size();
    }

    public String getValue(String key) {
        for (Property property : properties) {
            if (property.getKey().equals(key)) {
                return property.getValue();
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }
}
