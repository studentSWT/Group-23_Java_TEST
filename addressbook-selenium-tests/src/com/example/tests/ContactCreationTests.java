package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

    @Test(dataProvider = "randomValidContactGenerator")
    public void testNonEmptyContactCreation(ContactData contact) throws Exception {
	app.getNavigationHelper().openMainPage();
	
	// save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
 
	// actions
	app.getContactHelper().initNewContactCreation();
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().gotoHomePage();
   
    // save new state
    List<ContactData> newList = app.getContactHelper().getContacts(); 
    
    // compare states
    String lastName = contact.firstName;
    String firstName = contact.lastName;
    contact.firstName = firstName;
    contact.lastName = lastName;
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }

  //@Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	
	// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
	 
	// actions
	app.getContactHelper().initNewContactCreation();
    ContactData contact = new ContactData("", "", "", "", "", "", "", "", "-", "-", "-", "", "");
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().gotoHomePage();
    
    // save new state
    List<ContactData> newList = app.getContactHelper().getContacts(); 
    
    // compare states
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }
  
}
