package com.SAB.Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SAB.BaseConfig.BaseTest;
import com.SAB.GenerUtils.ExcelUtility;
import com.SAB.Pages.LoginPage;

public class LoginPageTest extends BaseTest {
	LoginPage lp;

	@Test(dataProvider = "Logindata")
	public void sendUserName(String user, String pwd) throws Exception {
		lp = new LoginPage(driver);
		lp.getUsername(user);
		Thread.sleep(1000);
		lp.getPassword(pwd);
		Thread.sleep(1000);
		lp.clickSubmit();
		Thread.sleep(1000);
		//System.out.println(s);
		//String actual = "Dashboard - SAB";
		/*
		 * if (b) { Assert.fail(); } else { Assert.assertTrue(true); }
		 */
		/*
		 * System.out.println(driver.getTitle()); String expected = driver.getTitle();
		 * Assert.assertEquals(actual, expected);
		 */

	}

	@DataProvider(name = "Logindata")
	public static Object[][] getLoginData() throws Exception {
		String path = ".\\src\\main\\java\\com\\SAB\\TestData\\LoginData.xlsx";
		ExcelUtility ex = new ExcelUtility(path);
		int rownum = ex.getRow("LoginData");
		int colnum = ex.getColNum("LoginData", 0);
		Object arr[][] = new Object[rownum][colnum];
		for (int i = 0; i < rownum; i++) {
			for (int j = 0; j < colnum; j++) {
				arr[i][j] = ex.getCellData("LoginData", i + 1, j);
			}
		}

		return arr;
	}

}
