package com.ait.tests;

import com.ait.phonebook.fwd.DataProviderContact;
import com.ait.phonebook.fwd.DataProviderUser;
import com.ait.phonebook.model.User;
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

    @Test(enabled = false)
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

    @Test(priority = 1, enabled = false)
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

    @Test(priority = 1, enabled = false)
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

    @Test(dataProvider = "addUserFromCSV",dataProviderClass= DataProviderUser.class)
    public void loginRegisterUserNegativeWithInvalidEmailTestDataFromProvider(User user) {
        //click on Login link
        app.getHeader().clickOnLoginLink();

        //fill login form with User class
        app.getUser().fillLoginRegForm(user);
        //click
        app.getUser().clickOnLoginButton();
        //verify
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
