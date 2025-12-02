package com.swaglabs.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserActions {

    private BrowserActions(){

    }

    @Step("Navigating to URL: {url}")
    public static void navigateToURL(WebDriver driver, String url){
        driver.get(url);
        LogsUtil.info("Navigated to URL: ", url);
    }

    @Step("Getting current URL")
    public static String getCurrentURL(WebDriver driver){
        LogsUtil.info("Current URL: ", driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    @Step("Getting page title")
    public static String getPageTitle(WebDriver driver){
        LogsUtil.info("Page title: ", driver.getTitle());
        return driver.getTitle();
    }

    @Step("Refreshing the page")
    public static void refreshPage(WebDriver driver){
        driver.navigate().refresh();
        LogsUtil.info("Refreshing the page");
    }

    @Step("Closing the browser")
    public static void closeBrowser(WebDriver driver) {
        LogsUtil.info("Closing the browser");
        if (driver != null) {
            driver.quit();
        }
    }


}
