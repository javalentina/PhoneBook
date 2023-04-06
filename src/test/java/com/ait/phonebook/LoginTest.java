package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            //click on Sign out
            //button[contains(.,'Sign Out')]
            app.getUser().clickOnSightOutButton();
        }
    }

    @Test(priority = 2)
    public void loginRegisterUserPositiveTest() {
        //click on Login link
        app.getHeader().clickOnLoginLink();
        //fill login form
        app.getUser().fillLoginRegForm(new User().setEmail("val+1@gmail.com").setPassword("Val123465$"));
        //click
        app.getUser().clickOnLoginButton();
        //verify
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }

    @Test(priority = 1)
    public void loginRegisterUserNegativeWithInvalidPasswordTest() {
        //click on Login link
        app.getHeader().clickOnLoginLink();
        //fill login form
        app.getUser().fillLoginRegForm(new User().setEmail("val+1@gmail.com").setPassword( "Val123465"));
        //click
        app.getUser().clickOnLoginButton();
        //verify
        Assert.assertTrue(app.getUser().isAlertPresent());

    }

    @Test(priority = 1)
    public void loginRegisterUserNegativeWithInvalidEmailTest() {
        //click on Login link
        app.getHeader().clickOnLoginLink();

        //fill login form
        app.getUser().fillLoginRegForm(new User().setEmail("val+1@gmail.com1").setPassword("Val123465$"));
        //click
        app.getUser().clickOnLoginButton();
        //verify
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
