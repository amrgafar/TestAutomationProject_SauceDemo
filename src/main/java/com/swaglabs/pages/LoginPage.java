package com.swaglabs.pages;

import com.swaglabs.utils.BrowserActions;
import com.swaglabs.utils.CustomSoftAssertion;
import com.swaglabs.utils.ElementActions;
import com.swaglabs.utils.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    // locators
    private WebDriver driver;
    // my locators are private to apply encapsulation
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    //Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Navigate to the login page
    @Step("Navigate to the login page")
    public void navigateToLoginPage(){
        BrowserActions.navigateToURL(driver,"https://www.saucedemo.com/");
    }


    //Actions
    @Step("Enter username: {0}")
    public LoginPage enterUsername(String username){
        ElementActions.sendData(driver, this.username, username);
        return this;
    }

    @Step("Enter password: {0}")
    public LoginPage enterPassword(String password){
        ElementActions.sendData(driver, this.password, password);
        return this;
    }


    @Step("Click login button")
    public LoginPage clickingLoginButton(){
        ElementActions.clickElement(driver, loginButton);
        return this;
    }

    @Step("Get error message")
    public String getErrorMessage(){
        return ElementActions.getText(driver,errorMessage);
    }


    //Validations
    @Step("Assert login page URL")
    public LoginPage assertLoginPageURL(){
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getCurrentURL(driver),"https://www.saucedemo.com/inventory.html");
        return this;
    }

    @Step("Assert login page title")
    public LoginPage assertLoginPageTitle(){
        CustomSoftAssertion.softAssertion.assertEquals(BrowserActions.getPageTitle(driver),"Swag Labs");
        return this;
    }

    @Step("Assert successful login")
    public LoginPage assertSuccessfulLoginSoft(){
        assertLoginPageURL().assertLoginPageTitle();
        return this;
    }

//    @Step("Assert successful login")
//    public HomePage assertSuccessfulLogin() {
//        driver.validate().validatePageUrl(getPropertyValue("homeURL"));
//        return new HomePage(driver);
//    }

    @Step("Assert unsuccessful login")
    public LoginPage assertUnsuccessfulLogin(){
        Validations.validateEquals(getErrorMessage(),"Epic sadface: Sorry, this user has been locked out.","Error Message");
        return this;
    }



}
