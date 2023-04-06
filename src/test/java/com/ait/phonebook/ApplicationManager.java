package com.ait.phonebook;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ApplicationManager {

    WebDriver driver;
    UserHelper user;
    ContactHelper contact;
    HomePageHelper home;
    HeaderHelper header;




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
        //open Chrome driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("remote-allow-origins=*");
        driver = new ChromeDriver(options);

        //open Page
        driver.get("https://telranedu.web.app");

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
