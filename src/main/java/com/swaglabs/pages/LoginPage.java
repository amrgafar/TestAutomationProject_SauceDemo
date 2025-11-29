package com.swaglabs.pages;

import com.swaglabs.utils.BrowserActions;
import com.swaglabs.utils.ElementActions;
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
    public void navigateToLoginPage(){
        BrowserActions.navigateToURL(driver,"https://www.saucedemo.com/");
    }


    //Actions
    public LoginPage enterUsername(String username){
        ElementActions.sendData(driver, this.username, username);
        return this;
    }

    public LoginPage enterPassword(String password){
        ElementActions.sendData(driver, this.password, password);
        return this;
    }


    public LoginPage clickingLoginButton(){
        ElementActions.clickElement(driver, loginButton);
        return this;
    }

    public String getErrorMessage(){
        return ElementActions.getText(driver,errorMessage);
    }


    //Validations
    public LoginPage assertSuccessfulLogin(){
        Assert.assertEquals(BrowserActions.getCurrentURL(driver),"https://www.saucedemo.com/inventory.html");
        return this;
    }

    public LoginPage assertUnsuccessfulLogin(){
        Assert.assertEquals(getErrorMessage(),"Epic sadface: Sorry, this user has been locked out.");
        return this;
    }



}
