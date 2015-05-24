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
		for (int i = 0; i < 1; i++) {
			GroupData group = new GroupData()
			.withName(generateRandomString())
			.withHeder(generateRandomString())
			.withFooter(generateRandomString());
			list.add(new Object[]{group});
		}
        return list.iterator();
    }
    
	@DataProvider
    public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 1; i++) {
			    ContactData contact = new ContactData()
			    .withFirstName(generateRandomString())
			    .withLastName(generateRandomString())
			    .withAddress1(generateRandomString())
			    .withPhoneHome(generateRandomString())
			    .withPhoneMobile(generateRandomString())
			    .withPhoneWork(generateRandomString())
			    .withEmail1(generateRandomString())
			    .withEmail2(generateRandomString())
			    .withBirthDay("10")
			    .withBirthMonth("June")
			    .withBirthYear("1980")
			    .withAddress2(generateRandomString())
			    .withPhoneHome2(generateRandomString());	
		        list.add(new Object[]{contact});
		}
        return list.iterator();
    }
	
  public String generateRandomString() {
	    Random rnd = new Random();
	    if (rnd.nextInt(4) == 0) {
	    	return "";
	    } else {
	    	return "aa" + rnd.nextInt();
	    }	  
  }
  
}