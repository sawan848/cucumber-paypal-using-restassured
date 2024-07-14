package org.example.app.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 6/13/2023
 * 12:31 PM
 */
public final class ConfigReader {
    private static ConfigReader readerInstance;
    private Properties properties;

    /**
     * Private constructor to restrict instantiation from outside the class
     */
    private ConfigReader(){}



    /**
     * Get a single instance of  the JSONUtility class
     * @return ConfigReader
     */
    public static synchronized ConfigReader getReaderInstance(){
        if ( readerInstance==null ){
            readerInstance=new ConfigReader ();
        }
        return readerInstance;
    }

    /**
     * This method is used to load the properties from config.properties file
     * @return it returns properties  object
     */
    public Properties init_properties() {

        properties = new Properties ();
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/properties/application.properties");
            properties.load(ip);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;

    }

}
