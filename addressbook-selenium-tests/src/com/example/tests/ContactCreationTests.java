package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().initNewContactCreation();
    ContactData contact = new ContactData();
    contact.firstName = "vika4";
    contact.lastName = "kot3";
    contact.address1 = "addr";
    contact.phoneHome = "111";
    contact.phoneMobile = "222";
    contact.phoneWork = "333";
    contact.email1 = "aaa@bb.cc";
    contact.email2 = "aaa1@bb.cc";
    contact.birthDay = "10";
    contact.birthMonth = "June";
    contact.birthYear = "1980";
    contact.address2 = "address3";
    contact.phoneHome2 = "555";
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().gotoHomePage();
  }
  
  @Test
  public void testEmptyDateNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
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
  }

  @Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().initNewContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "-", "", ""));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().gotoHomePage();
  }
}
