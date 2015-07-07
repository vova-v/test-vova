package com.crmtronic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateNewCategoriesWindow extends CategoriesPage{
	
	Categories categories = new Categories();

	public CreateNewCategoriesWindow(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "name")
	private WebElement fieldNameCategories;
	
	@FindBy(xpath = "//a[@class = 'select2-choice']")
	private WebElement selectPreloadedCategories;
	
	@FindBy(xpath = "//input[@aria-activedescendant = 'select2-result-label-234']")
	private WebElement fieldPreloadedCategories;
	
	@FindBy(xpath = "//button[contains(text(), 'Создать')]")
	private WebElement buttonCreate;
	
	public CreateNewCategoriesWindow typeFieldNameCategories(){
		wait.until(ExpectedConditions
				.visibilityOf(fieldNameCategories)).clear();
		wait.until(ExpectedConditions
				.visibilityOf(fieldNameCategories)).sendKeys(categories.getName());
		return this;
	}
	
	public CreateNewCategoriesWindow selectPreloadedCategories() throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOf(selectPreloadedCategories))
				.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//div[contains(text(), '"+categories.getPreloadedCategories()+"')]/.."))).click();
		return this;
	}
	
	
	public void clickButtonCreate() throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOf(buttonCreate)).click();
	}
	
	public EditCategoriesPage createNewCategories() throws InterruptedException{
		typeFieldNameCategories();
		selectPreloadedCategories();
		clickButtonCreate();
		return PageFactory.initElements(driver, EditCategoriesPage.class);
	}


}
