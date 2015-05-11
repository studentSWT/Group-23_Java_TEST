package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	@Test
	public void modifySomeContactEdit() {
		app.getNavigationHelper().openMainPage();
		
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		// actions
		app.getContactHelper().initContactModificationViaEdit(2);
	    ContactData contact = new ContactData();
	    contact.firstName = "REC333_vika4";
	    contact.lastName = "REC333_kot3";   
		app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().gotoHomePage();
	    
	    // save new state
	    List<ContactData> newList = app.getContactHelper().getContacts(); 
	    
	    //compare states
	    assertEquals(newList.size(), oldList.size() + 1);
	    
	    oldList.remove(2);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	    
	}
	
	@Test
	public void modifySomeContactDetails() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModificationViaDetails(2);
		app.getContactHelper().initContactModify();
	    ContactData contact = new ContactData();
	    contact.firstName = "REC333_Modify_vika4";
	    contact.lastName = "REC333_Modify_kot3";   
		app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().gotoHomePage();
	}
	
}
