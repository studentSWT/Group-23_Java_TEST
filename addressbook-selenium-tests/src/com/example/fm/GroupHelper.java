package com.example.fm;

import static com.example.fm.ContactHelper.CREATION;
import static com.example.fm.ContactHelper.MODIFICATION;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase{

	private SortedListOf<GroupData> cachedGroups;
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	public GroupHelper(ApplicationManager manager) {
		super(manager);		
	}
	
	public SortedListOf<GroupData> getGroups() {
		manager.navigateTo().groupsPage();
		if (cachedGroups == null) {
			rebuildCache();
		}
		return cachedGroups;
	}

	public void rebuildCache() {
		cachedGroups = new SortedListOf<GroupData>();
		manager.navigateTo().groupsPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
            String name = title.substring("Select (".length(), title.length() - ")".length());
			cachedGroups.add(new GroupData().withName(name));	
		}
		//return cachedGroups;
	}
	
	public GroupHelper createGroup(GroupData group) {
	   	manager.navigateTo().groupsPage();
		  initNewGroupCreation();
          fillGroupForm(group,CREATION);
          submitGroupCreation();
          returnToGroupsPage();
          rebuildCache();
          return this;
	}

	public GroupHelper midifyGroup(int index, GroupData group) {
	       initGroupModification(index);
	       fillGroupForm(group,MODIFICATION);
	       submitGroupModification();
	       returnToGroupsPage();	
	       rebuildCache();
	       return this;
	}
	
	public GroupHelper deleteGroup(int index) {
		selectGroupByIndex(index);
		submitGroupDeletion();	
		cachedGroups = null;
		returnToGroupsPage();
		rebuildCache();
		return this;
	}

	//---------------------------------------------------------------
	
	public GroupHelper initNewGroupCreation() {
	    click(By.name("new"));
		return this;
	  }

	public GroupHelper submitGroupCreation() {
	    click(By.name("submit"));
	    cachedGroups = null;
	    return this;
	  }

	public GroupHelper fillGroupForm(GroupData group, boolean formType) {
	    type(By.name("group_name"), group.getName());
	    
        if (formType == CREATION) {    	
	    } else {
	    	//if (driver.findElements(By.name("new_group")).size() != 0) {
	    	//throw new Error("Group selector exists in contact modification form");
	        //}
	    }	
	    type(By.name("group_header"), group.getHeader());
	    type(By.name("group_footer"), group.getFooter());
	    return this;
	  }

	public GroupHelper returnToGroupsPage() {
	    click(By.linkText("group page"));
	    return this;
	  }

	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));	
		cachedGroups = null;
		return this;
	}
	
	public GroupHelper submitGroupDeletion() {
		click(By.name("delete"));
		cachedGroups = null;
		return this;
	}
	
	
}