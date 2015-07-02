package com.crmtronic.testbase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Capabilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

import com.crmtronic.pages.DropMailPage;
import com.crmtronic.pages.LoginPage;
import com.crmtronic.pages.NavigateMenu;
import com.crmtronic.pages.RegistrationPage;
import com.crmtronic.util.PropertyLoader;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;

  protected WebDriver driver;
  
  protected LoginPage loginPage;
  protected RegistrationPage registrationPage;
  protected DropMailPage dropMailPage;
  protected NavigateMenu navigateMenu ;

  @BeforeSuite
  public void initTestSuite() throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");
    gridHubUrl = PropertyLoader.loadProperty("grid.url");
    if ("".equals(gridHubUrl)) {
      gridHubUrl = null;
    }
    capabilities = PropertyLoader.loadCapabilities();
    WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
  }

  @BeforeSuite
  public void initWebDriver() {
    driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
  }
  
  @BeforeTest
  public void initPageObjects() {
    loginPage = PageFactory.initElements(driver, LoginPage.class);
    registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
    dropMailPage = PageFactory.initElements(driver, DropMailPage.class);
    navigateMenu = PageFactory.initElements(driver, NavigateMenu.class);
    
    driver.manage().window().maximize();
    driver.get(baseUrl);
    
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
	  driver.quit();
    //WebDriverFactory.dismissAll();
  }
}
