package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {

    //send Keys
    @Step("Sending data: {data} to the element: {locator}")
    public static void sendData(WebDriver driver, By locator, String data){
        Waits.waitForElementVisible(driver, locator);
        Scrolling.scrollToElement(driver, locator);
        findElement(driver, locator).sendKeys(data);
        LogsUtil.info("Data entered: ", data, " in the field: ", locator.toString() );
    }

    //click
    @Step("Clicking on the element: {locator}")
    public static void clickElement(WebDriver driver, By locator){
        Waits.waitForElementClickable(driver, locator);
        findElement(driver, locator).click();
        LogsUtil.info("Clicked on the element: ", locator.toString());
    }

    //Get Text
    @Step("Getting text from the element: {locator}")
    public static String getText(WebDriver driver, By locator){
        Waits.waitForElementVisible(driver,locator);
        Scrolling.scrollToElement(driver, locator);
        LogsUtil.info("Getting text from the element: ", locator.toString()," Text: ", findElement(driver, locator).getText());
        return findElement(driver, locator).getText();
    }
    //no need to add @Step because this is executed too much
    public static WebElement findElement(WebDriver driver, By locator){
        LogsUtil.info("Finding element: ", locator.toString());
        return driver.findElement(locator);
    }

}
