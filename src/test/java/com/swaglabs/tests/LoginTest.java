package com.swaglabs.tests;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;

public class LoginTest {

    //variables
    private WebDriver driver;

    File allure_results = new File("test-outputs/allure-results");


    //Tests
    @Test
    public void successfulLogin() {
        new LoginPage(driver).enterUsername("standard_user").
                enterPassword("secret_sauce").
                clickingLoginButton().
                assertSuccessfulLoginSoft();
        ScreenshotsUtils.takeScreenshot(driver, "successful-login");
    }



    //Configurations

    @BeforeSuite
    public void beforeSuite(){
        FilesUtils.deleteFiles(allure_results);
    }

    @BeforeMethod
    void setUp(){
        driver = new ChromeDriver();
        new LoginPage(driver).navigateToLoginPage();
//        driver = DriverManager.createInstance("Chrome");
//        new LoginPage(DriverManager.getDriver()).navigateToLoginPage();
    }

    @AfterMethod
     public void tearDown(){
        BrowserActions.closeBrowser(driver);
        CustomSoftAssertion.customAssertAll();
    }

    @AfterClass
    public void afterClass(){
        AllureUtils.attacheLogsToAllureReport();
    }



}
