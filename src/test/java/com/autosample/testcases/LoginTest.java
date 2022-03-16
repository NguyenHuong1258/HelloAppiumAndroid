package com.autosample.testcases;

import com.autosample.login.LoginPage;
import com.base.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;


public class LoginTest extends BaseTest {
    private  static AppiumDriver driver;
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
