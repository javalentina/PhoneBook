package com.ait.tests;

import com.ait.phonebook.model.Contact;
import com.ait.phonebook.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase{

    //precodition: verify User log out , log in

    //click on add link

    //fill add contact form

    // click on save button

    //check Contact is added

    @DataProvider
    public Iterator<Object[]> addContactWithData(){
        List <Object[]> list= new ArrayList<>();
        list.add(new Object[]{"Lisa", "Wolf","98743289871","lis@lis.de","Alufeira","Sing Alone"});
        list.add(new Object[]{"Lesha", "Welf","3453589871","lesha@lis.de","Silves","Sing together"});
        list.add(new Object[]{"Nina", "Wilf","34534567589871","nina@lis.de","Faro","Sing no"});

        return list.iterator();
    }

    @DataProvider
    public Iterator <Object[]> addContactFromCSV(){
        List <Object[]> list= new ArrayList<>();

        return list.iterator();
    }
    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isSignOutButtonPresent()){
            app.getHeader().clickOnLoginLink();
        }

        app.getUser().fillLoginRegForm(new User().setEmail("val+1@gmail.com").setPassword("Val123465$"));

        // click on Registration button
        app.getUser().clickOnLoginButton();
    }
    @Test (enabled = false)
    public void addContactPositiveTest(){
       int i = (int) (System.currentTimeMillis()/1000)%3600;
        app.getContact().clickOnAddLink();
        app.getContact().addContact(new Contact().setName("Jim" + i).setSurName("Ranger").setPhone("12345678900").setEmail("ji@gmail.co").setAddress("Berlin").setDesc("west"));

        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreated("Jim"));
    }
    @Test (dataProvider = "addContactWithData")
    public void addContactPositiveFromDataProviderTest(String name, String surName, String phone, String email, String address, String desc){

        app.getContact().clickOnAddLink();
        app.getContact().addContact(new Contact()
                .setName(name )
                .setSurName(surName)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDesc(desc));

        app.getContact().clickOnSaveButton();
        app.getContact().removeContact();
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
