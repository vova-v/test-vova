package com.crmtronic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CategoriesPage extends NavigateMenu{

	public CategoriesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[@class = 'ctrl-btn btn-icon-blue add-new-category-btn']")
	private WebElement buttonAddNewCategories;
	
	@FindBy(xpath = "//button[@class = 'ctrl-btn btn-icon-blue add-new-category-btn']")
	private WebElement buttonAddNewCategories1;
	
	public CreateNewCategoriesWindow clickButtonAddNewCategories(){
		wait.until(ExpectedConditions
				.visibilityOf(buttonAddNewCategories)).click();
		return PageFactory.initElements(driver, CreateNewCategoriesWindow.class);
	}

}
