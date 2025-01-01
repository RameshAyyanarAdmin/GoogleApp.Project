package com.googleApp.reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportManager {
 
	public static ExtentReports report;
	public static ThreadLocal<ExtentTest> exTest=new ThreadLocal<ExtentTest>();
			
	
	public static void initialize() {
		report=new ExtentReports(".\\Reports\\AutomationReport.html");
	}
	
	public static ExtentTest getExtTest() {
		return exTest.get();
	}
	
	public static void setExtentTest(ExtentTest test) {
		exTest.set(test);
	}
}
