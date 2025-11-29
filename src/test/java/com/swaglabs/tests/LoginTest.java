package com.swaglabs.tests;

import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.CustomSoftAssertion;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL); // it substitute implicit wait
        driver = new ChromeDriver();
        new LoginPage(driver).navigateToLoginPage();
    }

    @AfterMethod
     public void tearDown(){
        driver.quit();
        CustomSoftAssertion.customAssertAll();
    }



}
