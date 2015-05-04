package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	@Test
	public void deleteSomeGroupEdit() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModificationViaEdit(7);
		app.getContactHelper().submitContactRemoving();
		app.getContactHelper().gotoHomePage();
	}
	
	@Test
	public void deleteSomeGroupModify() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModificationViaDetails(1);
		app.getContactHelper().initContactModify();
		app.getContactHelper().submitContactRemoving();
		app.getContactHelper().gotoHomePage();
	}	
}