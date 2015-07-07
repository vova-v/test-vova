package com.crmtronic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditCategoriesPage extends CategoriesPage{

	public EditCategoriesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[contains(text(), 'Сохранить')]")
	private WebElement buttonSave;
	
	public EditCategoriesPage clickButtonSave(){
		wait.until(ExpectedConditions.visibilityOf(buttonSave)).click();
		return this;
	}

}
