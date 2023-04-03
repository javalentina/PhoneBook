package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase{
    //precondition  add contact
    //click on the contact card
    //click on remove button
    //check Contact is removed
    @BeforeMethod
    public void ensurePreconditionMethod(){
        if(!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))){
            //click on Sign out
            //button[contains(.,'Sign Out')]
            click(By.xpath("//button[contains(.,'Sign Out')]"));

        }else{
            click(By.xpath("//a[contains(.,'LOGIN')]"));

            //fill login form
            type(By.cssSelector("[placeholder='Email']"), "val+1@gmail.com");
            type(By.cssSelector("[placeholder='Password']"), "Val123465$");

            //click
            click(By.name("login"));

            click(By.cssSelector("a:nth-child(5)"));
            int i = (int) (System.currentTimeMillis()/1000)%3600;
            type(By.cssSelector("input:nth-child(1)"),"Jim" +i);
            type(By.cssSelector("input:nth-child(2)"),"Ranger");
            type(By.cssSelector("input:nth-child(3)"),"12345678900");
            type(By.cssSelector("input:nth-child(4)"),"ji@gmail.co");
            type(By.cssSelector("input:nth-child(5)"),"Berlin");
            type(By.cssSelector("input:nth-child(6)"),"west");

            click(By.cssSelector(".add_form__2rsm2 button"));
        }
    }

    @Test
    public void RemoveContactTest(){
        int sizeBefore = sizeOfContacts();
        System.out.println(sizeBefore);

        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[contains(.,'Remove')]"));
        pause(2000);
        int sizeAfter = sizeOfContacts();

        System.out.println(sizeAfter);
        Assert.assertEquals(sizeBefore-1,sizeAfter);
    }

    public int sizeOfContacts() {
        if(isElementPresent(By.cssSelector(".contact-item_card__2SOIM")))
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        else
            return 0;

    }

}
