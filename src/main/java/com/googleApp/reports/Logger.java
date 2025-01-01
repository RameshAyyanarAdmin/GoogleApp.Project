package com.googleApp.reports;

import com.relevantcodes.extentreports.LogStatus;

public class Logger {
	
	public static void logPASS(String message) {
		ExtentReportManager.getExtTest().log(LogStatus.PASS,message);	
	}

	public static void logFAIL(String message) {
		ExtentReportManager.getExtTest().log(LogStatus.FAIL,message);	
	}
	
	public static void logSKIP(String message) {
		ExtentReportManager.getExtTest().log(LogStatus.SKIP,message);	
	}
	
	public static void logINFO(String message) {
		ExtentReportManager.getExtTest().log(LogStatus.INFO,message);	
	}
	
	public static void logWARN(String message) {
		ExtentReportManager.getExtTest().log(LogStatus.WARNING,message);	
	}
	
	public static void logFATAL(String message) {
		ExtentReportManager.getExtTest().log(LogStatus.FATAL,message);	
	}

}
