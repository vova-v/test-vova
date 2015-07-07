package com.crmtronic.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.crmtronic.pages.DashboardPage;
import com.crmtronic.pages.IsElementPresent;
import com.crmtronic.pages.PasswordRecoveryPage;
import com.crmtronic.testbase.TestNgTestBase;

public class LoginTest extends TestNgTestBase {
	
	@Test()
	public void testLoginOK() throws InterruptedException {
		DashboardPage rezult = loginPage.verifiLoginIn("staging@crmtronic.com", "123456789a");
		Assert.assertTrue(rezult.getNamePage().equals("Панель управления"));
	}
  
	@Test()
	public void testGoPagePasswordRecovery() throws InterruptedException {
		PasswordRecoveryPage rezult = loginPage.clickLingForgotPassword();
		Assert.assertTrue(rezult.getButtonText().equals("Отправить"));
	}
	
  
}
