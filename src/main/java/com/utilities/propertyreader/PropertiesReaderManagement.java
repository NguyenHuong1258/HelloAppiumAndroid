package com.utilities.propertyreader;

public class PropertiesReaderManagement {
    private static PropertiesReaderManagement instance;
    private static ConfigPropertiesReader configPropertiesReader;

    // private constructor in singleton design pattern
    private PropertiesReaderManagement() {}

    public static PropertiesReaderManagement getInstance() {
        if(instance == null) {
            instance = new PropertiesReaderManagement();
        }
        return instance;
    }

    //Get instance of ConfigPropertiesReader
    public ConfigPropertiesReader getConfigPropertiesReader() {
        return (configPropertiesReader == null) ? new ConfigPropertiesReader() : configPropertiesReader;
    }

}
