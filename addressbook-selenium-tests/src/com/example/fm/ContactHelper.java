package com.example.fm;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);	
	}

	public void submitContactCreation() {
	   click(By.name("submit"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstName);
	    type(By.name("lastname"), contact.lastName);
	    type(By.name("address"), contact.address1);
	    type(By.name("home"), contact.phoneHome);
	    type(By.name("mobile"), contact.phoneMobile);
	    type(By.name("work"), contact.phoneWork);
	    type(By.name("email"), contact.email1);
	    type(By.name("email2"), contact.email2);
	    selectByText(By.name("birthday"), contact.birthDay);
	    selectByText(By.name("birthmonth"), contact.birthMonth);
	    type(By.name("byear"), contact.birthYear);
	    // selectByText(By.name("new_group"), "group 1");
	    type(By.name("address2"), contact.address2);
	    type(By.name("phone2"), contact.phoneHome2);
	}

	private void selectContactByIndex(int index, String alt) {
		index = index + 1;
		click(By.xpath("//tr[" + index + "]/td/a/img[@alt='" + alt + "']"));
	}
	
	public void initContactModification(int index, String alt) {
		selectContactByIndex(index, alt);
	}
	
	public void initNewContactCreation() {
	    click(By.linkText("add new"));
	}

	public void submitContactModification(String alt) {
		click(By.xpath("//input[@value='" + alt + "']"));
	}

	public void initContactModify() {
		click(By.name("modifiy"));		
	}
	public void gotoHomePage() {
	    click(By.linkText("home"));
	}
}
