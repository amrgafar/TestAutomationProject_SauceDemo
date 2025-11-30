package com.swaglabs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserActions {

    private BrowserActions(){

    }

    public static void navigateToURL(WebDriver driver, String url){
        driver.get(url);
        LogsUtil.info("Navigated to URL: ", url);
    }

    public static String getCurrentURL(WebDriver driver){
        LogsUtil.info("Current URL: ", driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public static String getPageTitle(WebDriver driver){
        LogsUtil.info("Page title: ", driver.getTitle());
        return driver.getTitle();
    }

    public static void refreshPage(WebDriver driver){
        driver.navigate().refresh();
        LogsUtil.info("Refreshing the page");
    }

    public static void closeBrowser(WebDriver driver) {
        LogsUtil.info("Closing the browser");
        if (driver != null) {
            driver.quit();
        }
    }


}
