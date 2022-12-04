package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReaderUtils {
    private static Properties properties;

    private PropertiesReaderUtils(){}

    private static void readProperties(){
        properties= new Properties();
        try {
            System.out.println("LOADING...");
            properties.load(new FileReader("configuration/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFieldValue(String value){
        if(properties==null) readProperties();
        return properties.getProperty(value);
    }

}
