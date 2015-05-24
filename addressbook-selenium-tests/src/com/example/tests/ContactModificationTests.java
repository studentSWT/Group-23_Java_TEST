package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Random;

import static com.example.fm.ContactHelper.MODIFICATION;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactEdit(ContactData contact) {
		app.navigateTo().mainPage();
		
		// save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		 Random rnd = new Random();
		 int index = rnd.nextInt(oldList.size() - 1);
		    
		// actions
		 app.getContactHelper().midifyContact(index, contact);
	    
		// save new state
		 SortedListOf<ContactData> newList = app.getContactHelper().getContacts(); 
	    
	    // compare states	    
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
	    
	    assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
	    //oldList.remove(index);   
	    //oldList.add(contact);
	    //Collections.sort(oldList);
	    //Collections.sort(newList);
	    //assertEquals(newList, oldList);
	}
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContactDetails(ContactData contact) {
		app.navigateTo().mainPage();
		
		// save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
		 Random rnd = new Random();
		 int index = rnd.nextInt(oldList.size() - 1);
		 
		// actions
		app.getContactHelper().initContactModificationViaDetails(index + 1)
				.initContactModify()
				.fillContactForm(contact, MODIFICATION)
				.submitContactModification()
				.gotoHomePage();
	    
		// save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts(); 
	    
	    // compare states
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
	    
	    assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
	    
	    //oldList.remove(index);   
	    //oldList.add(contact);
	    //Collections.sort(oldList);
	    //Collections.sort(newList);
	    //assertEquals(newList, oldList);
	}
	
}
