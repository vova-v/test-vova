package com.crmtronic.testbase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Capabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

import com.crmtronic.pages.CategoriesPage;
import com.crmtronic.pages.CreateNewCategoriesWindow;
import com.crmtronic.pages.DropMailPage;
import com.crmtronic.pages.EditCategoriesPage;
import com.crmtronic.pages.IsElementPresent;
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
  protected NavigateMenu navigateMenu;
  protected CategoriesPage categoriesPage;
  protected CreateNewCategoriesWindow createNewCategoriesWindow;
  protected EditCategoriesPage editCategoriesPage;

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

  @BeforeTest
  public void initWebDriver() {
    driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
    
  }
  
  @BeforeMethod
  public void initPageObjects() {
	loginPage = PageFactory.initElements(driver, LoginPage.class);
	registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
	dropMailPage = PageFactory.initElements(driver, DropMailPage.class);
	navigateMenu = PageFactory.initElements(driver, NavigateMenu.class);
	categoriesPage = PageFactory.initElements(driver, CategoriesPage.class);
	createNewCategoriesWindow = PageFactory.initElements(driver, CreateNewCategoriesWindow.class);
	editCategoriesPage = PageFactory.initElements(driver, EditCategoriesPage.class);
	
    
    driver.manage().window().maximize();
  }
  
  @BeforeMethod
  public void startMethod() {
    driver.get(baseUrl);
  }
  
  
  @AfterMethod
  public void endMethod() throws InterruptedException {
	  Thread.sleep(2000);
	  if(new IsElementPresent().isElementPresent(navigateMenu.menuUserName) != false ){
		  navigateMenu.logout();
		  Thread.sleep(1000);
		  driver.navigate().refresh();
	  }
  }
 

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
	  driver.quit();
    //WebDriverFactory.dismissAll();
  }
}
