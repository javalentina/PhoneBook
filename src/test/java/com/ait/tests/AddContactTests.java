package com.ait.tests;

import com.ait.phonebook.fwd.DataProviderContact;
import com.ait.phonebook.model.Contact;
import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {

    //precodition: verify User log out , log in

    //click on add link

    //fill add contact form

    // click on save button

    //check Contact is added



    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isSignOutButtonPresent()) {
            app.getHeader().clickOnLoginLink();
        }

        app.getUser().fillLoginRegForm(new User().setEmail("val+1@gmail.com").setPassword("Val123465$"));

        // click on Registration button
        app.getUser().clickOnLoginButton();
    }

    @Test(enabled = false)
    public void addContactPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        app.getContact().clickOnAddLink();
        app.getContact().addContact(new Contact().setName("Jim" + i).setSurName("Ranger").setPhone("12345678900").setEmail("ji@gmail.co").setAddress("Berlin").setDesc("west"));

        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreated("Jim"));
    }

    @Test(enabled = false, dataProvider = "addContactWithData",dataProviderClass= DataProviderContact.class)
    public void addContactPositiveFromDataProviderTest(String name, String surName, String phone, String email, String address, String desc) {

        app.getContact().clickOnAddLink();
        app.getContact().addContact(new Contact()
                .setName(name)
                .setSurName(surName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDesc(desc));

        app.getContact().clickOnSaveButton();
        app.getContact().removeContact();
        
    }

    @Test(enabled = false, dataProvider = "addContactFromCSV",dataProviderClass = DataProviderContact.class)
    public void addContactPositiveFromCSVFileTest(Contact contact) {

        app.getContact().clickOnAddLink();
        app.getContact().addContact(contact);

        app.getContact().clickOnSaveButton();
        app.getContact().removeContact();
        app.getContact().pause(2000);
    }

    @Test(enabled = false)
    public void addContactNegativeTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        app.getContact().clickOnAddLink();

        app.getContact().addContact(new Contact().setName("Jim" + i).setSurName("Ranger").setPhone("12345678900").setEmail("jigmail.co").setAddress("Berlin").setDesc("west"));

        app.getContact().clickOnSaveButton();
        Assert.assertFalse(app.getContact().isContactCreated("John"));
    }

}
