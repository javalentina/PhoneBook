package com.ait.phonebook.fwd;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {

    String browser;
    static WebDriver driver;
    UserHelper user;
    ContactHelper contact;
    HomePageHelper home;
    HeaderHelper header;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public ApplicationManager(String browser) {
        this.browser=browser;
    }


    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HomePageHelper getHome() {
        return home;
    }

    public HeaderHelper getHeader() {
        return header;
    }
    public void init() {
        System.err.close();
        //open Chrome driver
        if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("remote-allow-origins=*");
            driver = new ChromeDriver(options);
            logger.info("All test  start in Chrome browser");
        }else if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            logger.info("All test  start in Firefox browser");
        }else if (browser.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
            logger.info("All test  start in Safari browser");
        }


        //open Page
        driver.get("https://telranedu.web.app");
        logger.info("Current URL -->" + driver.getCurrentUrl());

        //full Window and elements loading
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        home = new HomePageHelper(driver);
        header = new HeaderHelper(driver);
    }
    public void stop() {
        driver.quit();
    }

}
