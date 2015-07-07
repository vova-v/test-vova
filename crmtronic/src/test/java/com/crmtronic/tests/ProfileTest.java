package com.crmtronic.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crmtronic.mongodb.WorkWithMongo;
import com.crmtronic.pages.RegistrationPage;
import com.crmtronic.testbase.TestNgTestBase;

public class ProfileTest extends TestNgTestBase{
	
	
	@Test()
	public void testEditAvatarProfileSelectLocal() throws InterruptedException {
		loginPage.verifiLoginIn("staging@crmtronic.com", "123456789a");

	}

}
