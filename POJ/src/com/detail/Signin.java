package com.detail;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signin {
	
	public Signin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="account")
	public WebElement sign_in;
	

}

