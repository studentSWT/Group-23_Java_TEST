package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;



import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	
	// save old state
	List<ContactData> oldList = app.getContactHelper().getContacts();
 
	// actions
	app.getContactHelper().initNewContactCreation();
    ContactData contact = new ContactData();
    contact.firstName = "1114qqq";
    contact.lastName = "11113";
    contact.address1 = "addr";
    contact.phoneHome = "111";
    contact.phoneMobile = "222";
    contact.phoneWork = "333";
    contact.email1 = "ccccc@bb.cc";
    contact.email2 = "nnnnn1@bb.cc";
    contact.birthDay = "10";
    contact.birthMonth = "June";
    contact.birthYear = "1980";
    contact.address2 = "address3";
    contact.phoneHome2 = "555";
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().gotoHomePage();
   
    // save new state
    List<ContactData> newList = app.getContactHelper().getContacts(); 
    
    // compare states
    // assertEquals(newList.size(), oldList.size() + 1);
    
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);
  }
  
  @Test
  public void testEmptyDateNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	
	// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
	 
	// actions
	app.getContactHelper().initNewContactCreation();
    ContactData contact = new ContactData();	
    contact.firstName = "EmptyDate";
    contact.lastName = "qq";
    contact.address1 = "ww";
    contact.phoneHome = "234";
    contact.phoneMobile = "345";
    contact.phoneWork = "456";
    contact.email1 = "hhh@yandex.ru";
    contact.email2 = "qqq@gmail.com";
    contact.birthDay = "-";
    contact.birthMonth = "-";
    contact.birthYear = "1970";
    contact.address2 = "address3";
    contact.phoneHome2 = "555";
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().gotoHomePage();
    
    // save new state
    List<ContactData> newList = app.getContactHelper().getContacts(); 
    
    // compare states
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);
  }

  @Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	
	// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
	 
	// actions
	app.getContactHelper().initNewContactCreation();
    ContactData contact = new ContactData("", "", "", "", "", "", "", "", "-", "-", "-", "", "");
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().gotoHomePage();
    
    // save new state
    List<ContactData> newList = app.getContactHelper().getContacts(); 
    
    // compare states
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);
  }
}
