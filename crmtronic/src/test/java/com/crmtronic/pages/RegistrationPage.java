package com.crmtronic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends PasswordRecoveryPage{
	Account account = new Account();

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@placeholder = 'Email']")
	private WebElement fieldEmail;
	
	@FindBy(xpath = "//input[@placeholder = 'Пароль']")
	private WebElement fieldPassword;
	
	@FindBy(id = "phone")
	private WebElement fieldPhone;
	
	@FindBy(id = "subdomain")
	private WebElement fieldSubdomain;
	
	@FindBy(name = "cfgCategory")
	private WebElement selectCfgCategory;
	
	@FindBy(id = "businessCategory")
	private WebElement fieldBusinessCategory;
	
	public void typeFieldEmail(){
		wait.until(ExpectedConditions
				.visibilityOf(fieldEmail)).clear();
		wait.until(ExpectedConditions
				.visibilityOf(fieldEmail)).sendKeys(account.getEmail());
		
	}
	
	public void typeFieldPassword(){
		wait.until(ExpectedConditions
				.visibilityOf(fieldPassword)).clear();
		wait.until(ExpectedConditions
				.visibilityOf(fieldPassword)).sendKeys(account.getPassword());
		
	}
	
	public void typeFieldPhone(){
		wait.until(ExpectedConditions
				.visibilityOf(fieldPhone)).clear();
		wait.until(ExpectedConditions
				.visibilityOf(fieldPhone)).sendKeys(account.getPhone());
		
	}
	
	public void typeFieldSubdomain(){
		wait.until(ExpectedConditions
				.visibilityOf(fieldSubdomain)).clear();
		wait.until(ExpectedConditions
				.visibilityOf(fieldSubdomain)).sendKeys(account.getSubdomain());
		
	}
	
	public void typeSelectCfgCategory(){
		Select select = new Select(selectCfgCategory);
		select.selectByVisibleText(account.getCfgCategory());
		
	}
	
	

	public void typeFieldBusinessCategory(){
		wait.until(ExpectedConditions
				.visibilityOf(fieldBusinessCategory)).clear();
		wait.until(ExpectedConditions
				.visibilityOf(fieldBusinessCategory))
				.sendKeys(account.getBusinessCategory());
		
	}
	
	

}
