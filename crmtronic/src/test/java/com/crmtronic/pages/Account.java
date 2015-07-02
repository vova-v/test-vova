package com.crmtronic.pages;

import java.util.Random;

public class Account {
	
	private String email;
	private String password = "1234567890a";
	private String phone = "+380631693114";
	private String subdomain = "avtotest" + new Random().nextInt(1000000);
	private String cfgCategory = "Стандартный";
	private String businessCategory = "Авто тест";

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getSubdomain() {
		return subdomain;
	}
	
	public void setSubdomain(String subdomain) {
		this.subdomain = subdomain;
	}
	
	public String getCfgCategory() {
		return cfgCategory;
	}
	
	public void setCfgCategory(String cfgCategory) {
		this.cfgCategory = cfgCategory;
	}
	
	public String getBusinessCategory() {
		return businessCategory;
	}
	
	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}

}
