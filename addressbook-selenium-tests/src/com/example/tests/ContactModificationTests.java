package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactEdit(ContactData contact) {
		app.getNavigationHelper().openMainPage();
		
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		 Random rnd = new Random();
		 int index = rnd.nextInt(oldList.size() - 1);
		    
		// actions
		app.getContactHelper().initContactModificationViaEdit(index + 1);
		app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactModification();
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
	    oldList.remove(index);   
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactDetails(ContactData contact) {
		app.getNavigationHelper().openMainPage();
		
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		 Random rnd = new Random();
		 int index = rnd.nextInt(oldList.size() - 1);
		 
		// actions
		app.getContactHelper().initContactModificationViaDetails(index + 1);
		app.getContactHelper().initContactModify();
		app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactModification();
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
	    oldList.remove(index);   
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
}
