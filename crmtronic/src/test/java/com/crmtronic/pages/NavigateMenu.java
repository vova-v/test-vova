package com.crmtronic.pages;

import org.apache.xml.dtm.ref.ExpandedNameTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
	
	public NavigateMenu clickMenuSettings(){
		wait.until(ExpectedConditions
				.visibilityOf(menuSettings)).click();
		return this;
	}
	
	public void clickMenuProfile(){
		wait.until(ExpectedConditions
				.visibilityOf(menuProfile)).click();
	}
	
	public void clickMenuDealings(){
		wait.until(ExpectedConditions
				.visibilityOf(menuDealings)).click();
	}

}
