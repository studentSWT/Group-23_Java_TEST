package com.example.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
	
  @DataProvider
  public Iterator<Object[]> randomValidContactGenerator(){
	  List<Object[]> list = new ArrayList<Object[]>();

	  for (int i = 0; i < 2; i++) {
	        ContactData contact = new ContactData();
	        contact.firstName = generateRandomString();
		    contact.lastName = generateRandomString();
		    contact.phoneHome = generateRandomString();
		    contact.email1 = generateRandomString();
		    contact.email2 = generateRandomString();
		    list.add(new Object[]{contact});
	  }
	  return list.iterator();
  }
  
  public String generateRandomString() {
	    Random rnd = new Random();
	    if (rnd.nextInt(4) == 0) {
	    	return "";
	    } else {
	    	return "test" + rnd.nextInt();
	    }	  
 }

  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
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
    String firstName = contact.lastName;
    String lastName = contact.firstName;
    contact.firstName = firstName;
    contact.lastName = lastName;
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);
  }
  
}
