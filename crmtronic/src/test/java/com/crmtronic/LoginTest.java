package com.crmtronic;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmtronic.pages.HomePage;
import com.crmtronic.pages.LoginPage;

public class LoginTest extends TestNgTestBase {

  private LoginPage loginPage;

  @BeforeMethod
  public void initPageObjects() {
    loginPage = PageFactory.initElements(driver, LoginPage.class);
    driver.manage().window().maximize();
    driver.get(baseUrl);
  }

  @Test
  public void testLogin() throws InterruptedException {
	  loginPage.verifiLoginPage();
  }
  
}
