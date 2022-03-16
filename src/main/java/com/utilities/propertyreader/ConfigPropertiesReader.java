package com.utilities.propertyreader;

import com.utilities.drivers.DriverTypes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesReader {
    private Properties properties;
    private final String configPropertiesFilePath = "src/main/resources/properties/Config.Properties";

    //Read & load Property file
    public ConfigPropertiesReader() {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(configPropertiesFilePath));
            properties = new Properties();

            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration file is not found at: " + configPropertiesFilePath);
        }
    }

   // Get Platforms Type
   public DriverTypes getDriverType() {
       String driverType = properties.getProperty("driver");
       if(driverType == null || driverType.equalsIgnoreCase("Android")) {
           return DriverTypes.ANDROID;
       } else if(driverType.equalsIgnoreCase("iOS")) {
           return DriverTypes.IOS;
       } else {
           throw new RuntimeException("Driver Key in Config.Properties file is not matched : " + driverType);
       }
   }

   //Get URL
    public String getURL(){
        String url =properties.getProperty("url");
        if (url != null){ return url; }
        else {
            throw new RuntimeException("url is not specified in the Config.properties file.");
        }
    }

    //Get appPackage
    public String getAppPackage(){
        String appPackage =properties.getProperty("appPackage");
        if (appPackage != null){ return appPackage; }
        else {
            throw new RuntimeException("appPackage is not specified in the Config.properties file.");
        }
    }

    //Get appActivity
    public String getAppActivity(){
        String appActivity =properties.getProperty("appActivity");
        if (appActivity != null){ return appActivity; }
        else {
            throw new RuntimeException("appActivity is not specified in the Config.properties file.");
        }
    }


}
