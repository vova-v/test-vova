package com.crmtronic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends PasswordRecoveryPage{
	public Account account = new Account();

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@type = 'email']")
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
	
	@FindBy(xpath = "//span[contains(text(), 'Регистрация')]")
	private WebElement buttonSubmit;
	
	public void typeFieldEmail(){
		wait.until(ExpectedConditions
				.visibilityOf(fieldEmail)).clear();
		System.out.println("4"+account.getEmail());
		wait.until(ExpectedConditions
				.visibilityOf(fieldEmail))
					.sendKeys(account.getEmail());
		
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
	
	public void selectCfgCategory(){
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
	
	public RegistrationPage clickButtonSingUp(){
		wait.until(ExpectedConditions
				.visibilityOf(buttonSubmit)).click();
		return this;
	}
	
	public String getMessageSuccessfulRegistration(){
		return wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//div[@class = 'alert alert-danger']"))).getText();
	}
	
	public LoginPage clickLinkOpenPageLogin(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//a[contains(text(), 'этой')]"))).click();
		return PageFactory.initElements(driver, LoginPage.class);
	}

	public RegistrationPage registerIn() throws InterruptedException {
		System.out.println("3"+account.getEmail());
		Thread.sleep(1000);
		typeFieldEmail();
		typeFieldPassword();
		typeFieldPhone();
		typeFieldSubdomain();
		selectCfgCategory();
		typeFieldBusinessCategory();
		clickButtonSingUp();
		return this;
	}
	
	
	

}
