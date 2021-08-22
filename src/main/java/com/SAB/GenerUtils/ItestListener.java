package com.SAB.GenerUtils;

import java.io.File;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.SAB.BaseConfig.BaseTest;
import com.SAB.Reports.ExtendReports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ItestListener extends BaseTest implements ITestListener {
	ExtentReports extent = ExtendReports.getExtentReports();
	ExtentTest test;
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName());
		test.log(Status.PASS, result.getName());
		test.log(Status.PASS, result.getTestContext().getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
		test.log(Status.FAIL, result.getThrowable());
		String name=result.getMethod().getMethodName();
		//System.out.println("This is ashok:" +name);
		driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentdir= System.getProperty("user.dir")+"//Screenshots"+name+System.currentTimeMillis()+".png";
		FileUtils.copyFile(src,new File(currentdir ));
		test.addScreenCaptureFromPath(currentdir);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			// TODO Auto-generated catch block
	
		}	
		
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
	

}
