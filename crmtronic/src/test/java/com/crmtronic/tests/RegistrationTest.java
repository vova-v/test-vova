package com.crmtronic.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crmtronic.pages.LoginPage;
import com.crmtronic.pages.RegistrationPage;
import com.crmtronic.testbase.TestNgTestBase;

public class RegistrationTest extends TestNgTestBase{

	
		@BeforeMethod
		public void setUp() throws InterruptedException{
			registrationPage.account.setEmail(dropMailPage.generedNewEmail());
			Thread.sleep(1000);
			loginPage.clickLingForgotPassword()
						.clickLingSingUp();
		}
	
		@Test()
		public void testRegistrationOkWithCategoryTour() throws InterruptedException {
			RegistrationPage register = registrationPage.registerIn();
			Assert.assertTrue(register.getMessageSuccessfulRegistration()
					.contains("Спасибо! Аккаунт создан."));
			LoginPage login = register.clickLinkOpenPageLogin()
					.verifiLoginIn(registrationPage.account.getEmail()
							, registrationPage.account.getPassword());
			Assert.assertTrue(login.getNamePage().equals("Панель управления"));
		}

}
