package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;
import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
import static com.example.fm.ContactHelper.CREATION;

public class ContactCreationTests extends TestBase{

    @Test(dataProvider = "randomValidContactGenerator")
    public void testNonEmptyContactCreation(ContactData contact) throws Exception {
	app.navigateTo().mainPage();
	
	// save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
 
	// actions
	app.getContactHelper().initNewContactCreation();
	app.getContactHelper().fillContactForm(contact,CREATION);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().gotoHomePage();
   
    // save new state
    List<ContactData> newList = app.getContactHelper().getContacts(); 
    
    // compare states
    String lastName = contact.firstName;
    String firstName = contact.lastName;
    String emailName;
    String phone;
    
    if (contact.email1.length() == 0) {
    	emailName = contact.email2;
    	contact.email1 = emailName;
		contact.email2 = "";
	}
    
    if (contact.phoneHome.length() == 0) {
    	if (contact.phoneMobile.length() == 0) {
    		if (contact.phoneWork.length() != 0){
    			phone = contact.phoneWork;
    	    	contact.phoneHome = phone;
    		}
		}  	
    	else {
			phone = contact.phoneMobile;
	    	contact.phoneHome = phone;
		}
	}  

    contact.firstName = firstName;
    contact.lastName = lastName;
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }

  //@Test
  public void testEmptyContactCreation() throws Exception {
	app.navigateTo().mainPage();
	
	// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
	 
	// actions
	app.getContactHelper().initNewContactCreation();
    ContactData contact = new ContactData("", "", "", "", "", "", "", "", "-", "-", "-", "", "");
	app.getContactHelper().fillContactForm(contact,CREATION);
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
