package com.ait.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddContactTests extends TestBase{

    //precodition: verify User log out , log in

    //click on add link

    //fill add contact form

    // click on save button

    //check Contact is added
    @BeforeMethod
    public void ensurePrecondition(){
        if(!isElementPresent(By.xpath("//a[contains(.,'Sign Out')]"))){
            click(By.xpath("//a[contains(.,'LOGIN')]"));
        }

        type(By.cssSelector("[placeholder='Email']"), "val+1@gmail.com");
        type(By.cssSelector("[placeholder='Password']"), "Val123465$");

        // click on Registration button
        click(By.name("login"));
    }
    @Test (priority=3)
    public void addContactPositiveTest(){
       int i = (int) (System.currentTimeMillis()/1000)%3600;
        click(By.cssSelector("a:nth-child(5)"));

        type(By.cssSelector("input:nth-child(1)"),"Jim" +i);
        type(By.cssSelector("input:nth-child(2)"),"Ranger");
        type(By.cssSelector("input:nth-child(3)"),"12345678900");
        type(By.cssSelector("input:nth-child(4)"),"ji@gmail.co");
        type(By.cssSelector("input:nth-child(5)"),"Berlin");
        type(By.cssSelector("input:nth-child(6)"),"west");

        click(By.cssSelector(".add_form__2rsm2 button"));
        Assert.assertTrue(isContactCreated("Jim"));
    }

    public boolean isContactCreated(String text){
        List<WebElement> contacts = driver.findElements(By.cssSelector("h2"));
        for (WebElement el:contacts){
            if(el.getText().contains(text))
                return true;

        }
        return false;
    }
}
