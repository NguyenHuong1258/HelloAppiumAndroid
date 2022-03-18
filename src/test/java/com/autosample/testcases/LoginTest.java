package com.autosample.testcases;

import com.autosample.login.LoginPage;
import com.base.BaseTest;
import com.utilities.waits.ElementsHelper;
import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class LoginTest extends BaseTest {
    private  static AppiumDriver driver;
    private final static Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());
    LoginPage loginPage;

    @BeforeTest
    public void setUpLoginTest() throws MalformedURLException {
        driver = getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void TestLogin(){
    loginPage.inputUsername("userName");
    loginPage.inputPass("Password");
    loginPage.clickLogin();
    Assert.assertEquals(loginPage.isShownError(),true);
    }
}
