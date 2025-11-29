package com.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    // locators
    private WebDriver driver;
    // my locators are private to apply encapsulation
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");

    //Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    //Actions
    public void enterUsername(String username){
        driver.findElement(this.username).sendKeys(username);
    }


    //Validations




}
