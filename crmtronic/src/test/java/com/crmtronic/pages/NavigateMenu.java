package com.crmtronic.pages;

import java.util.List;

import org.apache.xml.dtm.ref.ExpandedNameTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class NavigateMenu extends LoginPage{

	public NavigateMenu(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[contains(text(), 'Настройки')]/..")
	private WebElement menuSettings;
	
	@FindBy(xpath = "//span[contains(text(), 'Профиль')]/..")
	private WebElement menuProfile;
	
	@FindBy(xpath = "//span[contains(text(), 'Сделки')]/..")
	private WebElement menuDealings;
	
	@FindBy(xpath = "//*[@id='user-header']/a/span")
	public WebElement menuUserName;
	
	@FindBy(xpath = "//a[@href = '/sign-out']")
	private WebElement menuSingOut;
	
	@FindBy(xpath = "//span[contains(text(), 'Схема продаж')]/..")
	private WebElement menuCategories;
	
	
	
	
	public NavigateMenu clickMenuSettings(){
		wait.until(ExpectedConditions
				.visibilityOf(menuSettings)).click();
		return this;
	}
	
	public void clickMenuProfile(){
		wait.until(ExpectedConditions
				.visibilityOf(menuProfile)).click();
	}
	
	public void clickMenuCategories(){
		wait.until(ExpectedConditions
				.visibilityOf(menuCategories)).click();
	}
	
	public void clickMenuDealings(){
		wait.until(ExpectedConditions
				.visibilityOf(menuDealings)).click();
	}
	
	public void logout() throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(wait.until(ExpectedConditions
				.visibilityOf(menuUserName))).click().perform();
		action.moveToElement(wait.until(ExpectedConditions
				.visibilityOf(menuSingOut))).click().perform();
	}
	
	public Boolean verifiCategoriesMenu(String category){
		clickMenuDealings();
		return new IsElementPresent().isElementPresent(driver, By
				.xpath("//a[@class = 'check-for-changes'][@href = '/objects/by-category/"+category+"']"));
	}


}
