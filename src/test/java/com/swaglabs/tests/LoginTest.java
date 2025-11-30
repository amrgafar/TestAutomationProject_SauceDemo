package com.swaglabs.tests;

import com.swaglabs.drivers.DriverManager;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.BrowserActions;
import com.swaglabs.utils.CustomSoftAssertion;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    //variables
    private WebDriver driver;


    //Tests
    @Test
    public void successfulLogin() {
        new LoginPage(driver).enterUsername("standard_user").
                enterPassword("secret_sauce").
                clickingLoginButton().
                assertSuccessfulLoginSoft();
    }



    //Configurations
    @BeforeMethod
    void setUp(){
        driver = DriverManager.createInstance("Chrome");
        new LoginPage(DriverManager.getDriver()).navigateToLoginPage();
    }

    @AfterMethod
     public void tearDown(){
        BrowserActions.closeBrowser(driver);
        CustomSoftAssertion.customAssertAll();
    }



}
