package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.TestBase;

public class LoginPage extends TestBase {
	
@FindBy(name="username")
WebElement username;


//Initializing page objects
public LoginPage() {
	PageFactory.initElements(driver, this);
}
	public String ValidateLoginTitle()
	{
	return driver.getTitle();
	}
	public boolean validateCRMImage()
	{
		return username.isDisplayed();
	}
	public HomePage Login()
	{
		return null;
		
	}
}



