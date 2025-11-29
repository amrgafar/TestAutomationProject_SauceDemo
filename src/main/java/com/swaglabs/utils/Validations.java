package com.swaglabs.utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {

    private Validations(){
        //private constructor
    }

    public static void validateTrue(boolean condition, String message){
        Assert.assertTrue(condition, message);
    }

    public static void validateFalse(boolean condition, String message){
        Assert.assertFalse(condition, message);
    }

    public static void validateEquals(String actual, String expected, String message){
        Assert.assertEquals(actual, expected, message);
    }

    public static void validateNotEquals(String actual, String expected, String message){
        Assert.assertNotEquals(actual, expected, message);
    }

    public static void validatePageUrl(WebDriver driver, String expected){
        Assert.assertEquals(BrowserActions.getCurrentURL(driver), expected);
    }

    public static void validatePageTitle(WebDriver driver, String expected){
        Assert.assertEquals(BrowserActions.getPageTitle(driver), expected);
    }

}
