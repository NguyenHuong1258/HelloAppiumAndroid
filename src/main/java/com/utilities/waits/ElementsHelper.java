package com.utilities.waits;

import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsHelper {
    final AppiumDriver<?> driver;
    final WebDriverWait wait;
    private final static Logger LOGGER = LogManager.getLogger(ElementsHelper.class.getName());


    public ElementsHelper(AppiumDriver<?> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = createWebDriverWait(10);
    }

    private WebDriverWait createWebDriverWait(final long timeOutInSeconds) {
        return new WebDriverWait(driver, timeOutInSeconds);
    }

    public void sendKeyToTextBox (final By elementLocator, final String keyValue){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator)).sendKeys(keyValue);
            LOGGER.info("Sent key: %s to the textbox.,", keyValue);

        } catch (org.openqa.selenium.TimeoutException e) {
            LOGGER.info("Can not send key: %s to the textbox.,", keyValue);
        }
    }

    public void tapButton (final By elementLocator){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator)).click();
            LOGGER.info("Button is taken an action.");
        } catch (org.openqa.selenium.TimeoutException e) {
            LOGGER.info("Button is taken an action.");
        }
    }

    public String getText (final By elementLocator){
        String textInElement = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator)).getText();
        LOGGER.info("Text: %s is get successfully.", textInElement);
        return textInElement;

    }

}
