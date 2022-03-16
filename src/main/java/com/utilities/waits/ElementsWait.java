package com.utilities.waits;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsWait {
    final AppiumDriver<?> driver;
    final WebDriverWait wait;

    public ElementsWait(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = createWebDriverWait(10);
    }

    private WebDriverWait createWebDriverWait(final long timeOutInSeconds) {
        return new WebDriverWait(driver, timeOutInSeconds);
    }

    /**
     * Waits for element to be visible within 30 sec
     *
     * @param elementLocator
     */
    protected void waitForElementToBeVisible (final By elementLocator){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        } catch (org.openqa.selenium.TimeoutException e) {
        }
    }

    /**
     * Waits for element to be Clickable.
     *
     * @param elementLocator
     */
    protected  void waitForElementToBeClickable(final By elementLocator){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        }catch (org.openqa.selenium.TimeoutException e){
        }
    }

}
