package com.SAB.BaseConfig;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest implements AutoConstant{
	public WebDriver driver;
	@BeforeTest
	public void preCondition(){
		System.setProperty(chrome_key, chrome_value);
		//System.setProperty(firefox_key,firefox_value);
		driver=new ChromeDriver();
		//driver= new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest
	public void postCondition()
	{
		driver.close();
	}
	
	

}
