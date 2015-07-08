package com.crmtronic.pages;

import java.util.Random;

import com.crmtronic.mongodb.WorkWithMongo;

public class Categories {
	
	private String name = "AvtoTestCategories" + new Random().nextInt(1000000);
	private String preloadedCategories = new WorkWithMongo().getCategoryName().toString();
	private String documentLocation = "C:\\Users\\Vova\\Desktop\\";
	private String documentName = "тест тегов.docx";
	
	public String getPreloadedCategories() {
		return preloadedCategories;
	}
	
	public void setPreloadedCategories(String preloadedCategories) {
		this.preloadedCategories = preloadedCategories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDocumentLocation() {
		return documentLocation;
	}

	public void setDocumentLocation(String documentLocation) {
		this.documentLocation = documentLocation;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

}
