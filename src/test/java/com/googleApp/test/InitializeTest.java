package com.googleApp.test;

import java.util.Properties;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.googleApp.driver.Driver;
import com.googleApp.driver.DriverManager;
import com.googleApp.reports.ExtentReportManager;
import com.googleApp.utilities.*;

public class InitializeTest {
	
	public static Properties config=null;
	
	
	@BeforeMethod
	public void beforeTest(ITestResult TestContext) {
		Utilities.setCurrentTestName(TestContext.getMethod().getMethodName());
		Driver.initialize(ConfigReader.get("autURL"));	
	}
	
	@AfterMethod
	public void afterTest(ITestContext TestContext) {		
		DriverManager.getDriver().quit();
		ExtentReportManager.report.endTest(ExtentReportManager.getExtTest());
	}
	
	@BeforeSuite
	public static void beforeTestExecution() {
		ExtentReportManager.initialize();
		Utilities.config();
		Utilities.FetchExcelTestData();
	}
	
	@AfterSuite
	public static void afterTestExecution() {
		ExtentReportManager.report.flush();
	}
}