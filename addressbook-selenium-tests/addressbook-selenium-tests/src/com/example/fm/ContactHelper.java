package com.example.fm;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.tests.GroupData;

public class ContactHelper extends HelperBase {
	private List<ContactData> cachedContacts;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);	
	}

	public void submitContactCreation() {
	   click(By.name("submit"));
	   cachedContacts = null;
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
	    selectByText(By.name("bday"), contact.birthDay);
	    selectByText(By.name("bmonth"), contact.birthMonth);
	    type(By.name("byear"), contact.birthYear);
	    type(By.name("address2"), contact.address2);
	    type(By.name("phone2"), contact.phoneHome2);
	}
	
	public void initNewContactCreation() {
	    click(By.linkText("add new"));
	}

	public void initContactModify() {
		click(By.name("modifiy"));		
	}

	public void initContactModificationViaEdit(int index) {
		click(By.xpath("//tr[" + (index + 1) + "]/td/a/img[@alt='Edit']"));
	}

	public void initContactModificationViaDetails(int index) {
		click(By.xpath("//tr[" + (index + 1) + "]/td/a/img[@alt='Details']"));
	}
	
	public void submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		cachedContacts = null;
	}
	
	public void submitContactRemoving() {
		click(By.xpath("//input[@value='Delete']"));
		cachedContacts = null;
	}

	public void gotoHomePage() {
	    click(By.linkText("home"));
	}
	
	public List<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCacheContacts();
		}
		return cachedContacts;
	}

	public void rebuildCacheContacts() {
		 List<ContactData> cachedContacts = new ArrayList<ContactData>();
	     List<WebElement>  rows = driver.findElements(By.name("entry"));
	     
	     for (WebElement row : rows) {
		     ContactData contact = new ContactData(); 
		        String emails = row.findElement(By.xpath(".//td[1]/input")).getAttribute("accept");
		        int indexStr = emails.indexOf(";");
		        contact.firstName = row.findElement(By.xpath(".//td[2]")).getText();
		        contact.lastName = row.findElement(By.xpath(".//td[3]")).getText();
		        contact.email1 = row.findElement(By.xpath(".//td[4]")).getText();
		        contact.phoneHome =  row.findElement(By.xpath(".//td[5]")).getText();
		    	if (indexStr == -1) {
		    	    contact.email2 = "";
		    	} else {
					contact.email2 = emails.substring(indexStr + 1,emails.length());
				}	        
		    	cachedContacts.add(contact);
		 }			
	}
	
}
