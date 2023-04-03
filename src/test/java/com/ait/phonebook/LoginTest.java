package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
  @BeforeMethod
  public void ensurePrecondition(){
    if(!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))){
      //click on Sign out
      //button[contains(.,'Sign Out')]
      click(By.xpath("//button[contains(.,'Sign Out')]"));

    }
  }
  @Test (priority=2)
    public void loginRegisterUserPositiveTest(){
      //click on Login link
    click(By.xpath("//a[contains(.,'LOGIN')]"));

    //fill login form
    type(By.cssSelector("[placeholder='Email']"), "val+1@gmail.com");
    type(By.cssSelector("[placeholder='Password']"), "Val123465$");

      //click
    click(By.name("login"));
      //verify
    Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));

  }@Test(priority=1)
    public void loginRegisterUserNegativeWithInvalidPasswordTest(){
      //click on Login link
    click(By.xpath("//a[contains(.,'LOGIN')]"));

    //fill login form
    type(By.cssSelector("[placeholder='Email']"), "val+1@gmail.com");
    type(By.cssSelector("[placeholder='Password']"), "Val123465");

      //click
    click(By.name("login"));
      //verify

    Assert.assertTrue(isAlertPresent());

  }

  @Test(priority=1)
  public void loginRegisterUserNegativeWithInvalidEmailTest(){
    //click on Login link
    click(By.xpath("//a[contains(.,'LOGIN')]"));

    //fill login form
    type(By.cssSelector("[placeholder='Email']"), "val+1@gmail.com1");
    type(By.cssSelector("[placeholder='Password']"), "Val123465$");

    //click
    click(By.name("login"));
    //verify

    Assert.assertTrue(isAlertPresent());
  }
}
