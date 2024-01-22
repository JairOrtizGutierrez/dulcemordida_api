package com.dulcemordidaService.utils;

public class Constants {
//    public static String FOLDER_PATH = "C:/Users/Jair_/IdeaProjects/dulcemordidaService/src/main/resources/static/images/";
    public static String FOLDER_PATH = Constants.class.getClassLoader().getResource("static/images").toString().replace("file:/", "");
}