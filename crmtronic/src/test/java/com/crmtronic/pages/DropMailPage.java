package com.crmtronic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crmtronic.util.PropertyLoader;

public class DropMailPage extends Page {
	
	private WebDriver driver2;
	
	public DropMailPage(WebDriver driver) {
		super(driver);
	}

	
	public String generedNewEmail() throws InterruptedException{
		openInNewWindow1("http://dropmail.me/ru/");
		switchToWindow(1);
		String email = new WebDriverWait(driver, 30)
				.until(ExpectedConditions.presenceOfElementLocated(By
						.xpath("//span[@class = 'email']"))).getText();
		switchToWindow(0);
		return email;
	}
	
	public void openInNewWindow(String url) {
	    ((JavascriptExecutor) driver)
	                 .executeScript("window.open(arguments[0])", url);
	}
	
	public String openInNewWindow1(String url) {
	    String name = "some_random_name";
	    ((JavascriptExecutor) driver)
	         .executeScript("window.open(arguments[0],\"" + name + "\")", url);
	    return name;
	}
	
	public void switchToWindow(int number){
		  String handle = driver.getWindowHandles().toArray()[number].toString();
		  driver.switchTo().window(handle);	
		}
	

}
