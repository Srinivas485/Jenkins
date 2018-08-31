package com.detail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	public Login(WebDriver driver)
	
	{
	PageFactory.initElements(driver, this);	
	}

	@FindBy(id="log")
	public WebElement uname;
	
	@FindBy(id="pwd")
	public WebElement pwd;
	
	@FindBy(id="login")
	public WebElement login;
}

