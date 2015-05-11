package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	@Test
	public void deleteSomeContactEdit() {
		Integer i = 2;
		app.getNavigationHelper().openMainPage();
		
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
	 
		// actions
		app.getContactHelper().initContactModificationViaEdit(i);
		app.getContactHelper().submitContactRemoving();
		app.getContactHelper().gotoHomePage();
		
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts(); 
	    
	    // compare states
	    
	    oldList.remove(i);
	    
	    assertEquals(newList.size(), oldList.size());
	    //  Collections.sort(oldList);
	    //  Collections.sort(newList);
	    //  assertEquals(newList, oldList);
	}
	
	//@Test
	public void deleteSomeContactModify() {
		Integer i = 3;
		app.getNavigationHelper().openMainPage();
		
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
	 
		// actions
		app.getContactHelper().initContactModificationViaDetails(i);
		app.getContactHelper().initContactModify();
		app.getContactHelper().submitContactRemoving();
		app.getContactHelper().gotoHomePage();
		
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts(); 
	    
	    // compare states  
	    oldList.remove(i);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}	
}