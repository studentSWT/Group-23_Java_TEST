package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	@Test
	public void modifySomeContactEdit() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModificationViaEdit(2);
	    ContactData contact = new ContactData();
	    contact.firstName = "REC333_vika4";
	    contact.lastName = "REC333_kot3";   
		app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitContactModification();
	    app.getContactHelper().gotoHomePage();
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
