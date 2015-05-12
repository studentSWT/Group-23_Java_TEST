package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	@Test
	public void deleteSomeContactEdit() {
		app.getNavigationHelper().openMainPage();
		
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
	
		// actions
		app.getContactHelper().initContactModificationViaEdit(1);
		app.getContactHelper().submitContactRemoving();
		app.getContactHelper().gotoHomePage();
		
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts(); 
	    
	    // compare states
	    oldList.remove(0);    
	    //assertEquals(newList.size(), oldList.size());
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
	@Test
	public void deleteSomeContactModify() {
		app.getNavigationHelper().openMainPage();
		
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
	 
		// actions
		app.getContactHelper().initContactModificationViaDetails(1);
		app.getContactHelper().initContactModify();
		app.getContactHelper().submitContactRemoving();
		app.getContactHelper().gotoHomePage();
		
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts(); 
	    
	    // compare states  
	    oldList.remove(0);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}	
}