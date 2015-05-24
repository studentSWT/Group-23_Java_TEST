package com.example.fm;

import static com.example.fm.ContactHelper.CREATION;
import static com.example.fm.ContactHelper.MODIFICATION;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	private SortedListOf<ContactData> cachedContacts;
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);	
	}
	
	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCacheContacts();
		}
		return cachedContacts;
	}

	public void rebuildCacheContacts() {
		 cachedContacts = new SortedListOf<ContactData>();
	     List<WebElement>  rows = driver.findElements(By.name("entry"));
	     
	     for (WebElement row : rows) {
		     ContactData contact = new ContactData(); 
		        String emails = row.findElement(By.xpath(".//td[1]/input")).getAttribute("accept");
		        int indexStr = emails.indexOf(";");
		        contact.withFirstName(row.findElement(By.xpath(".//td[2]")).getText())
		               .withLastName(row.findElement(By.xpath(".//td[3]")).getText())
		               .withEmail1(row.findElement(By.xpath(".//td[4]")).getText())
		               .withPhoneHome(row.findElement(By.xpath(".//td[5]")).getText());
		    	if (indexStr == -1) {
		    	    contact.withEmail2("");
		    	} else {
					contact.withEmail2(emails.substring(indexStr + 1,emails.length()));
				}	        
		    	cachedContacts.add(contact);
		 }			
	}
	
	public ContactHelper createContact(ContactData contact) {
		initNewContactCreation();
		fillContactForm(contact,CREATION);
		submitContactCreation();
		gotoHomePage();
		rebuildCacheContacts();
		return this;
	}
	
	public ContactHelper midifyContact(int index, ContactData contact) {
		initContactModificationViaEdit(index + 1);
		fillContactForm(contact,MODIFICATION);
		submitContactModification();
		gotoHomePage();
		rebuildCacheContacts();
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		initContactModificationViaEdit(index + 1);
		submitContactRemoving();
		gotoHomePage();
		rebuildCacheContacts();
		return this;
	}
	
//------------------------------------------------------------------
	
	public ContactHelper submitContactCreation() {
	   click(By.name("submit"));
	   cachedContacts = null;
	   return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstName());
	    type(By.name("lastname"), contact.getLastName());
	    type(By.name("address"), contact.getAddress1());
	    type(By.name("home"), contact.getPhoneHome());
	    type(By.name("mobile"), contact.getPhoneMobile());
	    type(By.name("work"), contact.getPhoneWork());
	    type(By.name("email"), contact.getEmail1());
	    type(By.name("email2"), contact.getEmail2());
	    selectByText(By.name("bday"), contact.getBirthDay());
	    selectByText(By.name("bmonth"), contact.getBirthMonth());
	    type(By.name("byear"), contact.getBirthYear());
	    if (formType == CREATION) {	
	    } else {
	    }
	    type(By.name("address2"), contact.getAddress2());
	    type(By.name("phone2"), contact.getPhoneHome2());
		return this;
	}
	
	public ContactHelper initNewContactCreation() {
	    click(By.linkText("add new"));
		return this;
	}

	public ContactHelper initContactModify() {
		click(By.name("modifiy"));	
		return this;
	}

	public ContactHelper initContactModificationViaEdit(int index) {
		click(By.xpath("//tr[" + (index + 1) + "]/td/a/img[@alt='Edit']"));
		return this;
	}

	public ContactHelper initContactModificationViaDetails(int index) {
		click(By.xpath("//tr[" + (index + 1) + "]/td/a/img[@alt='Details']"));
		return this;
	}
	
	public ContactHelper submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		cachedContacts = null;
		return this;
	}
	
	public ContactHelper submitContactRemoving() {
		click(By.xpath("//input[@value='Delete']"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper gotoHomePage() {
	    click(By.linkText("home"));
	    return this;
	}

}
