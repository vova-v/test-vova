package com.crmtronic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page{
	Customer customer = new Customer();
	public WebDriverWait wait = new WebDriverWait(driver, 60);

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "email")
	private WebElement fieldLogin;
	
	@FindBy(name = "password")
	private WebElement fieldPassword;
	
	@FindBy(xpath = "//span[contains(text(), 'Войти')]")
	private WebElement buttonSubmit;
	
	public void typeFieldLogin(){
		fieldLogin.clear();
		fieldLogin.sendKeys(customer.getLogin());
		
	}
	
	public void typeFieldPassword(){
		fieldPassword.clear();
		fieldPassword.sendKeys(customer.getPassword());
		
	}
	
	public void clickButtonSubmit(){
		buttonSubmit.click();	
	}
	
	public void verifiLoginPage(){
		customer.setLogin("staging@crmtronic.com");
		customer.setPassword("123456789a");
		typeFieldLogin();
		typeFieldPassword();
		clickButtonSubmit();
		wait.until(ExpectedConditions.titleIs("CRM Tronic"));
	}

}
