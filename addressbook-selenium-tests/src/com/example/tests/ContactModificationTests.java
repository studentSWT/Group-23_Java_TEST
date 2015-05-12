package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	@Test
	public void modifySomeContactEdit() {
		app.getNavigationHelper().openMainPage();
		
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		// actions
		app.getContactHelper().initContactModificationViaEdit(1);
	    ContactData contact = new ContactData();
	    String firstName = "11REC333_vika4";
	    String lastName = "REC333_kot3"; 
	    contact.firstName = firstName;
	    contact.lastName = lastName;
	    contact.phoneHome =  "zzbb1230004567";
	    contact.email1 = "111rrrr@uu.rr"; 
        contact.email2 = "222hhh@mmmm.hhh";
		app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().gotoHomePage();
	    
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts(); 
	    
	    // compare states
	    contact.firstName = lastName;
	    contact.lastName = firstName;
	    oldList.remove(0);   
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
	@Test
	public void modifySomeContactDetails() {
		app.getNavigationHelper().openMainPage();
		
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		// actions
		app.getContactHelper().initContactModificationViaDetails(2);
		app.getContactHelper().initContactModify();
	    ContactData contact = new ContactData(); 
	    String firstName = "zEC333_Modify_kot3";
	    String lastName = "zzzz33_Modify_vika4"; 
	    contact.firstName = firstName;
	    contact.lastName = lastName;
	    contact.phoneHome =  "1234567";
	    contact.email1 = "rrrr@uu.rr"; 
        contact.email2 = "hhh@mmmm.hhh";
		app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().gotoHomePage();
	    
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts(); 
	    
	    // compare states
	    contact.firstName = lastName;
	    contact.lastName = firstName;
	    oldList.remove(1);   
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
}
