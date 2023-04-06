package com.ait.phonebook;

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
        if(!app.getHeader().isLoginLinkPresent()){
            //click on Sign out
            //button[contains(.,'Sign Out')]
            app.getUser().clickOnSightOutButton();

        }else{
            app.getHeader().clickOnLoginLink();

            //fill login form
            app.getUser().fillLoginRegForm(new User().setEmail("val+1@gmail.com").setPassword("Val123465$"));

            //click
            app.getUser().clickOnLoginButton();

            app.getContact().clickOnAddLink();
            int i = (int) (System.currentTimeMillis()/1000)%3600;
            app.getContact().addContact(new Contact().setName("Jim" + i).setSurName("Ranger").setPhone("12345678900").setEmail( "ji@gmail.co").setAddress("Berlin").setDesc("west") );

            app.getContact().clickOnSaveButton();
        }
    }

    @Test
    public void RemoveContactTest(){
        int sizeBefore = app.getContact().sizeOfContacts();
        System.out.println(sizeBefore);

        app.getContact().removeContact();
        app.getHome().pause(2000);
        int sizeAfter = app.getContact().sizeOfContacts();

        System.out.println(sizeAfter);
        Assert.assertEquals(sizeBefore-1,sizeAfter);
    }

}
