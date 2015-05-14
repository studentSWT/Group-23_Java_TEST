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
  
}