package com.crmtronic.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crmtronic.pages.RegistrationPage;
import com.crmtronic.testbase.TestNgTestBase;

public class ProfileTest extends TestNgTestBase{
	
	@BeforeMethod
	public void setUp(){
		loginPage.verifiLoginIn("staging@crmtronic.com", "123456789a");
		navigateMenu.clickMenuSettings()
					.clickMenuProfile();
	}
	
	@Test()
	public void testEditAvatarProfileSelectLocal() throws InterruptedException {
	
	}

}
