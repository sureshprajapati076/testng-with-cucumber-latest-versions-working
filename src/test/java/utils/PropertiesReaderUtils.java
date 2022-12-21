package utils;

import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReaderUtils {
    private static final ThreadLocal<Properties> threadLocalProperties = new ThreadLocal<>();

    private PropertiesReaderUtils() {
    }

    private static void readProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("configuration/config.properties"));
            threadLocalProperties.set(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getFieldValue(String value) {
        if (threadLocalProperties.get() == null) readProperties();
        return threadLocalProperties.get().getProperty(value);
    }

}
