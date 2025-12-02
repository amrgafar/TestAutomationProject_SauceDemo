package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

import static com.swaglabs.utils.ElementActions.findElement;

public class Scrolling {

    //Scroll to element
    @Step("Scrolling to the element: {0}")
    public static void scrollToElement(WebDriver driver, By locator){
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true)", findElement(driver, locator));

    }
}
