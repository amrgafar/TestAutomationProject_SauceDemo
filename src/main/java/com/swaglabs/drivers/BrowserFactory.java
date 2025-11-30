package com.swaglabs.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Locale;

public class BrowserFactory {
    public static WebDriver getBrowser(String browserName){
        switch (browserName.toLowerCase()){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-extensions");
                options.addArguments("disable-notifications");
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                //options.addArguments("--headless");
                return new ChromeDriver(options);

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--disable-extensions");
                firefoxOptions.addArguments("disable-notifications");
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                firefoxOptions.setAcceptInsecureCerts(true);
                //firefoxOptions.addArguments("--headless");
                return new FirefoxDriver(firefoxOptions);

            default:
                EdgeOptions EdgeOptions = new EdgeOptions();
                EdgeOptions.addArguments("--start-maximized");
                EdgeOptions.addArguments("--disable-extensions");
                EdgeOptions.addArguments("disable-notifications");
                EdgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                //EdgeOptions.addArguments("--headless");
                return new EdgeDriver(EdgeOptions);
        }
    }
}
