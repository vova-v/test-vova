package com.crmtronic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crmtronic.mongodb.WorkWithMongo;

public class CategoriesPage extends NavigateMenu{
	
	Categories categories = new Categories();
	public WorkWithMongo workWithMongo = new WorkWithMongo();

	public CategoriesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[@class = 'ctrl-btn btn-icon-blue add-new-category-btn']")
	private WebElement buttonAddNewCategories;
	
	@FindBy(id = "filter-categories")
	private WebElement fieldSearchCategories;
	
	public void clickButtonVisibilityClose(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//a[@class = 'bo-name'][@href = '/objects"
						+ "/by-category/"+workWithMongo.getCategory()+"']"
								+ "/../span/button[@class = 'js-category-visibility close']"))).click();
	}
	
	public CategoriesPage clickButtonCategoryDocument(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//a[@class = 'bo-name'][@href = '/objects/by-category/"+workWithMongo.getCategory()+"']"
						+ "/../span/button[@class = 'js-category-document close']"))).click();
		return this;
	}
	
	public CategoriesPage addDocument(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//input[@id = '"+workWithMongo.getCategory()+"-doc-upload']")))
					.sendKeys(categories.getDocumentLocation() + categories.getDocumentName());
		return this;
	}
	
	public CategoriesPage deleteDocument(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//li[@title = '"+categories.getDocumentName()+"']/i[@class = 'fa fa-fw fa-times-circle f-16 delete-icon doc-delete']")))
					.click();
		return this;
	}
	
	public CategoriesPage deleteCategory(){
		categories.setName(workWithMongo.getCategoryForDelete().toString());
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//a[@class = 'bo-name'][@href = '/objects"
						+ "/by-category/"+categories.getName()+"']"
								+ "/../span/button[@class = 'js-category-remove close']")))
					.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//center/button[@class = 'btn-popover-yes btn btn-green']"))).click();
		return this;
	}
	
	public Boolean verifiDocumentIsTrue(){
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//li[@title = '"+categories.getDocumentName()+"']")));
		return new IsElementPresent().isElementPresent(driver, By
				.xpath("//li[@title = '"+categories.getDocumentName()+"']"));
	}
	
	public Boolean verifiDocumentIsFalse(){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By
				.xpath("//li[@title = '"+categories.getDocumentName()+"']")));
		return new IsElementPresent().isElementPresent(driver, By
				.xpath("//li[@title = '"+categories.getDocumentName()+"']"));
	}
	
	public CreateNewCategoriesWindow clickButtonAddNewCategories(){
		wait.until(ExpectedConditions
				.visibilityOf(buttonAddNewCategories)).click();
		return PageFactory.initElements(driver, CreateNewCategoriesWindow.class);
	}
	
	public CategoriesPage typeFieldSearchCategories(){
		categories.setName(workWithMongo.getCategoryName().toString());
		wait.until(ExpectedConditions
				.visibilityOf(fieldSearchCategories)).clear();
		wait.until(ExpectedConditions
				.visibilityOf(fieldSearchCategories)).sendKeys(categories.getName());
		return this;
	}
	
	public Boolean verifiCategoriesIsTrue(){
		IsElementPresent isElementPresent = new IsElementPresent();
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//a[@class = 'bo-name'][@href = '/objects/by-category/"+workWithMongo.getCategory()+"']")));
		return isElementPresent.isElementPresent(driver, By
				.xpath("//a[@class = 'bo-name'][@href = '/objects/by-category/"+workWithMongo.getCategory()+"']"));
	}
	
	public Boolean verifiCategoriesIsFalse(){
		IsElementPresent isElementPresent = new IsElementPresent();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[@class = 'bo-name'][@href = '/objects/by-category/"+categories.getName()+"']")));
		return isElementPresent.isElementPresent(driver, By
				.xpath("//a[@class = 'bo-name'][@href = '/objects/by-category/"+categories.getName()+"']"));
	}


	
	

}
