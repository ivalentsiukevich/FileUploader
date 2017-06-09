package com.valentsiukevich.file_uploader.utils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * @author ilya_valentsiukevich
 * @version 1.0.0
 */
public class StringUtil {
    @NotNull
    private static String reverse(String text) {
        StringBuilder newText = new StringBuilder();
        int i = text.length() - 1;
        while (i >= 0) {
            newText.append(text.charAt(i));
            i--;
        }
        return newText.toString();
    }

    @NotNull
    public static String getFileExtension(String fileName) {
        StringBuilder fileExtension = new StringBuilder();
        int i = fileName.length() - 1;
        while (fileName.charAt(i) != '.') {
            fileExtension.append(fileName.charAt(i));
            i--;
        }
        return reverse(fileExtension.toString().toLowerCase());
    }

    @NotNull
    public static ArrayList<Property> getProperties(String[] args) {
        ArrayList<Property> properties = new ArrayList<>();
        for (int i = 0; i < args.length; i += 2) {
            properties.add(new Property(args[i], args[i + 1]));
        }
        return properties;
    }
}
