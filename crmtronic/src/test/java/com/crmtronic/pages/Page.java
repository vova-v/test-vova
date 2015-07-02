package com.crmtronic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {
	
	
	
  protected WebDriver driver;
  

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public Page(WebDriver driver) {
    this.driver = driver;
  }
  
  public String getNamePage() {
	return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By
    		.xpath("//div[@class = 'navbar-center w-300']"))).getText();
    
  }
  
  

}
