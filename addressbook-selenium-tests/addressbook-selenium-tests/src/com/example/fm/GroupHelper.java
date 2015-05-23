package com.example.fm;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase{

	private List<GroupData> cachedGroups;
	
	public GroupHelper(ApplicationManager manager) {
		super(manager);		
	}

	public void initNewGroupCreation() {
	    click(By.name("new"));
	  }

	public void submitGroupCreation() {
	    click(By.name("submit"));
	    cachedGroups = null;
	  }

	public void fillGroupForm(GroupData group) {
	    type(By.name("group_name"), group.name);
	    type(By.name("group_header"), group.header);
	    type(By.name("group_footer"), group.footer);
	  }

	public void returnToGroupsPage() {
	    click(By.linkText("group page"));
	  }

	public void deleteGroup(int index) {
		selectGroupByIndex(index);
		click(By.name("delete"));	
		cachedGroups = null;
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
	}

	public void initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		cachedGroups = null;
	}

	public void submitGroupModification() {
		click(By.name("update"));	
		cachedGroups = null;
	}

	public List<GroupData> getGroups() {
		if (cachedGroups == null) {
			cachedGroups = rebuildCache();
		}
		return cachedGroups;
	}

	public List<GroupData> rebuildCache() {
		List<GroupData> cachedGroups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");
			group.name = title.substring("Select (".length(), title.length() - ")".length());
			cachedGroups.add(group);	
		}
		return cachedGroups;
	}
	
}