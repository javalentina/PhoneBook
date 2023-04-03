package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{
    //precondition:user should be logged out
    @BeforeMethod
    public void ensurePrecondition(){
        if(!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))){
            //click on Sign out
            //button[contains(.,'Sign Out')]
            click(By.xpath("//button[contains(.,'Sign Out')]"));

        }
    }

    @Test
    public void NewUserRegistrationTest(){
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        //click on login Link
        Assert.assertTrue(isElementPresent(By.className("login_login__3EHKB")));


        //fill registration form

        type(By.cssSelector("[placeholder='Email']"), "val+1@gmail.com");
        type(By.cssSelector("[placeholder='Password']"), "Val123465$");

        // click on Registration button
        click(By.name("registration"));
        //verify sign out button displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
    }


}
