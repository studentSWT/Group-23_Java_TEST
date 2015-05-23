package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	
	@Test
	public void deleteSomeContactEdit() {
		app.getNavigationHelper().openMainPage();
		
		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		 Random rnd = new Random();
		 int index = rnd.nextInt(oldList.size() - 1);
	
		// actions
		app.getContactHelper().initContactModificationViaEdit(index + 1);
		app.getContactHelper().submitContactRemoving();
		app.getContactHelper().gotoHomePage();
		app.getContactHelper().rebuildCacheContacts();
		
		// save new state
	    List<ContactData> newList = app.getContactHelper().getContacts(); 
	    
	    // compare states
	    oldList.remove(index);    
	    //assertEquals(newList.size(), oldList.size());
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	}
	
}