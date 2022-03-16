package com.autosample.login;

import com.utilities.waits.ElementsHelper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ElementsHelper {

    public LoginPage(AppiumDriver<?> driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /***
     * Locators
     * */
    By userName_field   = By.id("com.dgotlieb.automationsample:id/userName");
    By passWord_field   = By.id("com.dgotlieb.automationsample:id/userPassword");
    By login_btn        = By.id("com.dgotlieb.automationsample:id/loginButton");
    By error_text       = By.id("com.dgotlieb.automationsample:id/errorTV");

    /***
     * Action
     * */
    //Input Username
    public void inputUsername(CharSequence userName) {
        sendKeyToTextBox(userName_field,"userName");
    }

    //Input Password
    public void inputPass(CharSequence passWord) {
        sendKeyToTextBox(passWord_field,"userPassword");
    }

    //Click Login
    public void clickLogin(){
        tapButton(login_btn);
    }

    //assertion: Show an error message
    public boolean isShownError(){
        String error_mgs = getText(error_text);
        return error_mgs.equals("Wrong username or password");
    }
}
