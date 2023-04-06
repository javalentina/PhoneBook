package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    //precondition:user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            //click on Sign out
            app.getUser().clickOnSightOutButton();

        }
    }

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        app.getHeader().clickOnLoginLink();
        //click on login Link
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        //fill registration form

        app.getUser().fillLoginRegForm(new User().setEmail("val+1@gmail.com").setPassword("Val123465$"));

        // click on Registration button
        app.getUser().clickOnRegistrationButton();
        //verify sign out button displayed
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }
    @Test
    public void newUserRegistrationNegativeWithoutPasswordTest() {
        app.getHeader().clickOnLoginLink();
        //click on login Link
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        //fill registration form

        app.getUser().fillLoginRegForm(new User().setEmail("val+1@gmail.com").setPassword("Val123465$"));

        // click on Registration button
        app.getUser().clickOnRegistrationButton();
        //verify sign out button displayed
        Assert.assertTrue(app.getUser().isAlertPresent());

    }
}
