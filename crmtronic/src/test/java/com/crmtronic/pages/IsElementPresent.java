package com.crmtronic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IsElementPresent {
	
	public boolean isElementPresent(WebDriver driver, By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (WebDriverException e) {
			return false;
		}
	}
	
	public boolean isElementPresent(WebElement webElement) {
		try {
			webElement.isDisplayed();
			return true;
		} catch (WebDriverException e) {
			return false;
		}
	}

}
