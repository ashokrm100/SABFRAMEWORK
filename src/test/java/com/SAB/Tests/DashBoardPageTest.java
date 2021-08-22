package com.SAB.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SAB.BaseConfig.BaseTest;
import com.SAB.Pages.DashBoardPage;
import com.SAB.Pages.LoginPage;

public class DashBoardPageTest extends BaseTest {
	LoginPage lp;
	DashBoardPage DBP;
	@Test
	public void inspectDashBoard()
	{
		try {
		lp = new LoginPage(driver); 
		lp.getUsername("ufr");
		lp.getPassword("SaB2018");
		lp.clickSubmit();
		DBP = new DashBoardPage(driver);
		Thread.sleep(1000);
		DBP.empDetails();
		Thread.sleep(1000);
		//System.out.println(driver.getTitle());
		String actual="MasterTable - 12AttendanceLanding";
		Assert.assertEquals(actual,driver.getTitle());
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
			
	}

	
	
}
