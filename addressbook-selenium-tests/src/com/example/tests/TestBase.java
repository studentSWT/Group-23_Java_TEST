package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fm.ApplicationManager;

public class TestBase {
 
	protected ApplicationManager app;
	
	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();    
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop(); 
	  }
	
	@DataProvider
    public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData();			
		    group.name = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();
			list.add(new Object[]{group});
		}
        return list.iterator();
    }
    
	@DataProvider
    public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			    ContactData contact = new ContactData();	
			    contact.firstName = generateRandomString();
			    contact.lastName = generateRandomString();
			    contact.address1 = generateRandomString();
			    contact.phoneHome = generateRandomString();
			    contact.phoneMobile = generateRandomString();
			    contact.phoneWork = generateRandomString();
			    contact.email1 = generateRandomString();
			    contact.email2 = generateRandomString();
			    contact.birthDay = "10";
			    contact.birthMonth = "June";
			    contact.birthYear = "1980";
			    contact.address2 = generateRandomString();
			    contact.phoneHome2 = generateRandomString();
		        list.add(new Object[]{contact});
		}
        return list.iterator();
    }
	
  public String generateRandomString() {
	    Random rnd = new Random();
	    if (rnd.nextInt(4) == 0) {
	    	return "";
	    } else {
	    	return "bb" + rnd.nextInt();
	    }	  
  }
  
}