package com.base;

import com.utilities.drivers.DriverManagement;
import com.utilities.drivers.DriverTypes;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {
    private static AppiumDriver<?> driver;
    public DriverManagement driverManagement;
    private static final String screenShotsFolder = "Screenshots";

    public AppiumDriver getDriver() throws MalformedURLException {
        driverManagement = new DriverManagement();
        driver = driverManagement.createDriver();
        return driver;
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }

    //Get screen-shot
    public String getScreenshotPath(String result, AppiumDriver<?> driver) throws IOException {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\Screenshots\\"+result+".png";
        FileHandler.copy(source,new File(destinationFile));
        return destinationFile;
    }

}
