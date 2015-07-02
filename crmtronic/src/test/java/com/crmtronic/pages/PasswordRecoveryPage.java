package com.crmtronic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasswordRecoveryPage extends LoginPage{

	public PasswordRecoveryPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[@class = 'btn btn-login btn-forgot']")
	private WebElement buttonSubmit;
	
	@FindBy(xpath = "//a[@href = '/sign-up']")
	private WebElement lingSingUp;
	
	public String getButtonText(){
		return wait.until(ExpectedConditions
				.visibilityOf(buttonSubmit)).getText();
	}
	
	public RegistrationPage clickLingSingUp(){
		wait.until(ExpectedConditions
				.visibilityOf(lingSingUp)).click();
		return PageFactory.initElements(driver, RegistrationPage.class);
	}
	
	

}
