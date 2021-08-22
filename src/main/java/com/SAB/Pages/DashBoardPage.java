package com.SAB.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SAB.BaseConfig.BaseTest;
import com.SAB.GenerUtils.GenericUtils;

public class DashBoardPage  {

	@FindBy(xpath="//span[text()='Emp Details']")
	@CacheLookup
	WebElement emp_Details;
	
	@FindBy(xpath="//span[text()='Operations']")
	@CacheLookup
	WebElement Operations;
	
	@FindBy(xpath="//span[text()='Master Table']")
	@CacheLookup
	WebElement master_table;
	
	@FindBy(xpath="//span[text()='HR']")
	@CacheLookup
	WebElement hr;
	
	@FindBy(xpath="//ul[@class='list-unstyled']//li/a")
	List<WebElement> Emplist;
	
	public DashBoardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void empDetails()
	{
		emp_Details.click();
		GenericUtils gc= new GenericUtils();
		WebElement mb=gc.handlelist(Emplist,"Attendance Details");
		mb.click();
	}
	
	public void operations()
	{
		Operations.click();
		
	}
	
	public void masterTable()
	{
		master_table.click();
	}
	

}
