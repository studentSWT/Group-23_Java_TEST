package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase{

    @Test(dataProvider = "randomValidContactGenerator")
    public void testNonEmptyContactCreation(ContactData contact) throws Exception {
	
	// save old state
    SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
 
	// actions
	app.getContactHelper().createContact(contact);
   
    // save new state
    SortedListOf<ContactData> newList = app.getContactHelper().getContacts(); 
    
    // compare states;
    
    String lastName = contact.getFirstName();
    String firstName = contact.getLastName();
    
    if (contact.getEmail1().length() == 0) {
    	contact.withEmail1(contact.getEmail2())
		       .withEmail2("");
	}
    
    if (contact.getPhoneHome().length() == 0) {
    	if (contact.getPhoneMobile().length() == 0) {
    		if (contact.getPhoneWork().length() != 0){
    	    	contact.withPhoneHome(contact.getPhoneWork());
    		}
		}  	
    	else {
	    	contact.withPhoneHome(contact.getPhoneMobile());
		}
	}  

    contact.withFirstName(firstName).withLastName(lastName);
    assertThat(newList, equalTo(oldList.withAdded(contact)));
    //oldList.add(contact);
    //Collections.sort(oldList);
    //Collections.sort(newList);
    //assertEquals(newList, oldList);
  }

}
