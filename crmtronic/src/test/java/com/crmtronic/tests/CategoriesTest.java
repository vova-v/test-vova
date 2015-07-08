package com.crmtronic.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmtronic.pages.IsElementPresent;
import com.crmtronic.testbase.TestNgTestBase;

public class CategoriesTest extends TestNgTestBase {
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		loginPage.verifiLoginIn("staging@crmtronic.com", "123456789a");
		Thread.sleep(2000);
		navigateMenu.clickMenuSettings()
					.clickMenuCategories();
	}
	
	//@Test()
	public void testCreateNewCategories() throws InterruptedException {
		categoriesPage.clickButtonAddNewCategories()
						.createNewCategories()
						.clickButtonSave();
		Thread.sleep(2000);
		
	}
	
	//@Test()
	public void testVerifiFieldSearchCategories() throws InterruptedException {
		categoriesPage.typeFieldSearchCategories();
		Assert.assertTrue(categoriesPage.verifiCategoriesIsTrue());
		
	}
	
	//@Test()
	public void testVerifiButtonVisibitiClose() throws InterruptedException {
		categoriesPage.clickButtonVisibilityClose();
		Assert.assertFalse(navigateMenu.verifiCategoriesMenu(categoriesPage
				.workWithMongo.getCategory().toString()));
		categoriesPage.clickButtonVisibilityClose();
		Assert.assertTrue(navigateMenu.verifiCategoriesMenu(categoriesPage
				.workWithMongo.getCategory().toString()));
		
	}
	
	//@Test()
	public void testVerifiDocumentCategory() throws InterruptedException {
		categoriesPage.clickButtonCategoryDocument().addDocument();
		Assert.assertTrue(categoriesPage.verifiDocumentIsTrue());
		categoriesPage.deleteDocument();
		Assert.assertFalse(categoriesPage.verifiDocumentIsFalse());
		
	}
	//пока не работает проверка что категория удалилась
	//@Test(priority = 2)
	public void testDeleteCategory() throws InterruptedException {
		categoriesPage.deleteCategory();
		Assert.assertFalse(categoriesPage.verifiCategoriesIsFalse());
		
	}
	
	@Test()
	public void testAddGroupStatusCategory() throws InterruptedException {
		categoriesPage.clickButtonEditCategory()
						.addNewGroupStatus();
		Assert.assertTrue(editCategoriesPage.verifiGroupStatusIsTrue());
		Thread.sleep(10000);
		driver.navigate().refresh();
		editCategoriesPage.deleteGroupStatus();
		driver.navigate().refresh();
		Assert.assertFalse(editCategoriesPage.verifiGroupStatusIsFalse());
		
	}
  

}
