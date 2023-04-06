package com.ait.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase {

    @Test
    public void headerTestElement() {
        //Check About  Menu Link
        //isElementPresent(By.cssSelector("body:nth-child(2) div.container:nth-child(1) div.navbar-component_nav__1X_4m:nth-child(1) > a:nth-child(3)"));
        isAboutLinkPresent();
    }


    public boolean isAboutLinkPresent(){
        return app.getUser().isElementPresent(By.cssSelector("body:nth-child(2) div.container:nth-child(1) div.navbar-component_nav__1X_4m:nth-child(1) > a:nth-child(3)"));

    }
    public boolean isHomeLinkPresent(){
        return  app.getUser().isElementPresent(By.cssSelector("body:nth-child(2) div.container:nth-child(1) div.navbar-component_nav__1X_4m:nth-child(1) > a.active:nth-child(2)"));
    }
    public boolean isLogoPresent(){
        return  app.getUser().isElementPresent(By.cssSelector("body:nth-child(2) div.container:nth-child(1) div.navbar-component_nav__1X_4m:nth-child(1) > h1:nth-child(1)"));
    }

}
