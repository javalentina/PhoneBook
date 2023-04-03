package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HeaderTests extends TestBase {

    @Test
    public void headerTestElement() {
        //Check About  Menu Link
        //isElementPresent(By.cssSelector("body:nth-child(2) div.container:nth-child(1) div.navbar-component_nav__1X_4m:nth-child(1) > a:nth-child(3)"));
        isLogoLinkPresent();
            }

    public boolean isAboutLinkPresent(){
        return isElementPresent(By.cssSelector("body:nth-child(2) div.container:nth-child(1) div.navbar-component_nav__1X_4m:nth-child(1) > a:nth-child(3)"));

    }
    public boolean isHomeLinkPresent(){
        return  isElementPresent(By.cssSelector("body:nth-child(2) div.container:nth-child(1) div.navbar-component_nav__1X_4m:nth-child(1) > a.active:nth-child(2)"));
    }
    public boolean isLogoPresent(){
        return  isElementPresent(By.cssSelector("body:nth-child(2) div.container:nth-child(1) div.navbar-component_nav__1X_4m:nth-child(1) > h1:nth-child(1)"));
    }

    public void isLogoLinkPresent(){
     driver.findElement(By.xpath("//h1[contains(text(),'PHONEBOOK')]")).getTagName().equals("a");
    }


}
