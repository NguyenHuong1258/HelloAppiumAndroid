package com.utilities.drivers;

import com.utilities.propertyreader.ConfigPropertiesReader;
import com.utilities.propertyreader.PropertiesReaderManagement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManagement {
    private DriverTypes driverTypes;
    private static AppiumDriver<?> driver;
    private String urlProperty;

    //Get Driver type from config.
    public DriverManagement(){
        driverTypes = PropertiesReaderManagement.getInstance().getConfigPropertiesReader().getDriverType();
        urlProperty = PropertiesReaderManagement.getInstance().getConfigPropertiesReader().getURL();

    }

    //Create driver.
    public AppiumDriver<?> createDriver() throws MalformedURLException {
        switch (driverTypes) {
            case ANDROID:
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("deviceName", "Nexus 4 API 30");
                caps.setCapability("udid", "emulator-5554");
                caps.setCapability("platform","Android");
                caps.setCapability("platformVersion", "11.0");
                caps.setCapability("skipUnlock", "true");
                caps.setCapability("appPackage", "com.dgotlieb.automationsample");
                caps.setCapability("appActivity", "com.dgotlieb.automationsample.MainActivity");
                driver = new AndroidDriver<MobileElement>(new URL(urlProperty), caps);

            case IOS:
                break;
        }
        return driver;

    }




}
