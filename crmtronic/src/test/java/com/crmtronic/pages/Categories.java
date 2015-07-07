package com.crmtronic.pages;

import java.util.Random;

import com.crmtronic.mongodb.WorkWithMongo;

public class Categories {
	
	private String name = "AvtoTestCategories" + new Random().nextInt(1000000);
	private String preloadedCategories = new WorkWithMongo().getCategoryName().toString();
	
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

}
