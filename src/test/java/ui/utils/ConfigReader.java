package ui.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    /*
        We should use Properties class and FileInputStream class to be able to read a file and retrieve a data.
         */
    private static Properties properties;

    /*
    we should create static block to run this piece of code first.
     */
    static {
        String path = "configuration.properties";
        try {
            FileInputStream input = new FileInputStream(path);//opens the file in the path
            properties = new Properties();
            properties.load(input);//loads the file details
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }


}