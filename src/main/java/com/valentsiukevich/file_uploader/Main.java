package com.valentsiukevich.file_uploader;

import com.valentsiukevich.file_uploader.controllers.Controller;
import com.valentsiukevich.file_uploader.utils.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties(args);
        Controller controller = new Controller();
        controller.start(properties);
    }
}