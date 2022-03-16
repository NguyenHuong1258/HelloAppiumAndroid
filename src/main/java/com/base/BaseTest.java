package com.base;

import com.utilities.drivers.DriverManagement;
import com.utilities.drivers.DriverTypes;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class BaseTest {
    private static AppiumDriver<?> driver;
    public DriverManagement driverManagement;

    public AppiumDriver getDriver() throws MalformedURLException {
        driverManagement = new DriverManagement();
        driver = driverManagement.createDriver();
        return driver;
    }

    @AfterSuite
    public void teardown() {
        driver.quit();
    }

}
