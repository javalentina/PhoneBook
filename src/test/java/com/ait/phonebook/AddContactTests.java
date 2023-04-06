package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    //precodition: verify User log out , log in

    //click on add link

    //fill add contact form

    // click on save button

    //check Contact is added
    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isSignOutButtonPresent()){
            app.getHeader().clickOnLoginLink();
        }

        app.getUser().fillLoginRegForm(new User().setEmail("val+1@gmail.com").setPassword("Val123465$"));

        // click on Registration button
        app.getUser().clickOnLoginButton();
    }
    @Test (priority=3)
    public void addContactPositiveTest(){
       int i = (int) (System.currentTimeMillis()/1000)%3600;
        app.getContact().clickOnAddLink();
        app.getContact().addContact(new Contact().setName("Jim" + i).setSurName("Ranger").setPhone("12345678900").setEmail("ji@gmail.co").setAddress("Berlin").setDesc("west"));

        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreated("Jim"));
    }

    @Test (priority=3)
    public void addContactNegativeTest(){
        int i = (int) (System.currentTimeMillis()/1000)%3600;
        app.getContact().clickOnAddLink();

        app.getContact().addContact(new Contact().setName("Jim" + i).setSurName("Ranger").setPhone("12345678900").setEmail("jigmail.co").setAddress("Berlin").setDesc("west"));

        app.getContact().clickOnSaveButton();
        Assert.assertFalse(app.getContact().isContactCreated("John"));
    }

}
