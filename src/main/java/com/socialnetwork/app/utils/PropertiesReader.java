package com.socialnetwork.app.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static PropertiesReader instance;

    private PropertiesReader(){

    }

    public static PropertiesReader getInstance(){
        if(instance == null){
            instance = new PropertiesReader();
        }
        return instance;
    }

    public void loadProps(){
        try (InputStream input = new FileInputStream("C:\\Users\\Mircea\\app.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("URL"));
            System.out.println(prop.getProperty("dbName"));
            System.out.println(prop.getProperty("dbPass"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
