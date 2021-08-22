package com.SAB.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReports {
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;
	
	public static ExtentReports getExtentReports()
	{
		String path=System.getProperty("user.dir")+"//Reports";
		reporter= new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("SAB Automation Report");
		reporter.config().setReportName("SAB LocalHost");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ashok Kumar");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Host", "LocalHost");
		return extent;
	}
	

}
