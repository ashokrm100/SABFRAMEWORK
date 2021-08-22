package com.SAB.Pages;

import java.awt.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id="username") WebElement userName;
	@FindBy(id="password") WebElement passWord;
	@FindBy(id="login-button") WebElement submit;
	@FindBy(id="username-error-message")WebElement errorMsg;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void getUsername(String name)
	{
		userName.sendKeys(name);
	}
	
	public void getPassword(String pwd)
	{
		passWord.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		submit.click();
		//String value= errorMsg.getText();
		userName.clear();
		passWord.clear();
		
		//boolean b = errorMsg.isDisplayed();
		//return value;
	}

}
