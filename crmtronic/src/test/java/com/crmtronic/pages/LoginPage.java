package com.crmtronic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page{
	
Customer customer = new Customer();
	
	public WebDriverWait wait = new WebDriverWait(driver, 30);

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "email")
	private WebElement fieldLogin;
	
	@FindBy(name = "password")
	private WebElement fieldPassword;
	
	@FindBy(xpath = "//span[contains(text(), 'Войти')]")
	private WebElement buttonSubmit;
	
	@FindBy(xpath = "//a[@href = '/forgot-password']")
	private WebElement lingForgotPassword;
	
	public void typeFieldLogin(){
		wait.until(ExpectedConditions
				.visibilityOf(fieldLogin)).clear();
		wait.until(ExpectedConditions
				.visibilityOf(fieldLogin))
					.sendKeys(customer.getLogin());
		
	}
	
	public void typeFieldPassword(){
		wait.until(ExpectedConditions
				.visibilityOf(fieldPassword)).clear();
		wait.until(ExpectedConditions
				.visibilityOf(fieldPassword))
					.sendKeys(customer.getPassword());

		
	}
	
	public void clickButtonSubmit(){
		wait.until(ExpectedConditions
				.visibilityOf(buttonSubmit)).click();
	}
	
	public PasswordRecoveryPage clickLingForgotPassword(){
		wait.until(ExpectedConditions
				.visibilityOf(lingForgotPassword)).click();
		return PageFactory.initElements(driver, PasswordRecoveryPage.class);
	}
	
	public DashboardPage verifiLoginIn(String login, String password){
		customer.setLogin(login);
		customer.setPassword(password);
		typeFieldLogin();
		typeFieldPassword();
		clickButtonSubmit();
		return PageFactory.initElements(driver, DashboardPage.class);
	}
	
	
	

}
