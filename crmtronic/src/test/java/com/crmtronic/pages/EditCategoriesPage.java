package com.crmtronic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EditCategoriesPage extends CategoriesPage{
	
	private static Categories categories = new Categories();

	public EditCategoriesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[contains(text(), 'Сохранить')]")
	private WebElement buttonSave;
	
	@FindBy(xpath = "//button[contains(text(), 'Добавить группу')]")
	private WebElement buttonAddGroupStatus;
	
	@FindBy(id = "tronicPromptInput")
	private WebElement fieldTronicPrompt;
	
	@FindBy(xpath = "//button[@class = 'btn-popover-yes btn btn-green']")
	private WebElement buttonSaveTronicPrompt;
	
	public EditCategoriesPage clickButtonSave(){
		wait.until(ExpectedConditions.visibilityOf(buttonSave)).click();
		return this;
	}
	
	public EditCategoriesPage clickButtonAddGroupStatus(){
		wait.until(ExpectedConditions.visibilityOf(buttonAddGroupStatus)).click();
		return this;
	}
	
	public EditCategoriesPage typeFieldTronicPrompt(String value){
		wait.until(ExpectedConditions.visibilityOf(fieldTronicPrompt)).clear();
		wait.until(ExpectedConditions.visibilityOf(fieldTronicPrompt)).sendKeys(value);
		return this;
	}
	
	public EditCategoriesPage clickButtonSaveTronicPrompt(){
		wait.until(ExpectedConditions.visibilityOf(buttonSaveTronicPrompt)).click();
		return this;
	}
	
	public EditCategoriesPage addNewGroupStatus(){
		clickButtonAddGroupStatus()
			.typeFieldTronicPrompt(categories.getNameGroupStatus())
			.clickButtonSaveTronicPrompt();
		clickButtonSave();
		return this;
		
	}
	
	public EditCategoriesPage deleteGroupStatus(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//h2[contains(text(), '"+categories.getNameGroupStatus()+"')]"
						+ "/../button[@class = 'btn-none f-16 fa fa-times fa-red remove-group']"))).click();
		clickButtonSave();
		return this;
		
	}
	
	public Boolean verifiGroupStatusIsTrue(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(), '"+categories.getNameGroupStatus()+"')]")));
		return new IsElementPresent().isElementPresent(driver, By
				.xpath("//h2[contains(text(), '"+categories.getNameGroupStatus()+"')]"));
	}
	
	public Boolean verifiGroupStatusIsFalse(){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h2[contains(text(), '"+categories.getNameGroupStatus()+"')]")));
		return new IsElementPresent().isElementPresent(driver, By
				.xpath("//h2[contains(text(), '"+categories.getNameGroupStatus()+"')]"));
	}
	

}
