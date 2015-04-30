package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	@Test
	public void deleteSomeGroupEdit() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification(7,"Edit");
		app.getContactHelper().submitContactModification("Delete");
		app.getContactHelper().gotoHomePage();
	}
	
	@Test
	public void deleteSomeGroupModify() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification(1,"Details");
		app.getContactHelper().initContactModify();
		app.getContactHelper().submitContactModification("Delete");
		app.getContactHelper().gotoHomePage();
	}	
}