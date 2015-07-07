package com.crmtronic.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmtronic.testbase.TestNgTestBase;

public class CategoriesTest extends TestNgTestBase {
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		loginPage.verifiLoginIn("staging@crmtronic.com", "123456789a");
		Thread.sleep(2000);
		navigateMenu.clickMenuSettings()
					.clickMenuCategories();
	}
	
	@Test()
	public void testCreateNewCategories() throws InterruptedException {
		categoriesPage.clickButtonAddNewCategories()
						.createNewCategories()
						.clickButtonSave();
		Thread.sleep(2000);
		
	}
  

}
