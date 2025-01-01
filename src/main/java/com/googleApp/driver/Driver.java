package com.googleApp.driver;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.googleApp.constants.Constants;
import com.googleApp.utilities.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	public static WebDriver driver;	
	public Driver(String url) {
		if (ConfigReader.get("executionMode").equalsIgnoreCase("local"))
		{
			startLocalExecution();	
		}
		else if(ConfigReader.get("executionMode").equalsIgnoreCase("Remote")) 
		{
			startRemoteExecution();	
		}
		DriverManager.setDriver(driver);
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Constants.implicitWait, TimeUnit.SECONDS);
		DriverManager.getDriver().get(url);
		DriverManager.getDriver().manage().deleteAllCookies();
	}

	public static void initialize(String url) {
		new Driver(url);
	}

	public static void startLocalExecution() {  
		try {	 
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			options.addArguments("start-maximized");
			driver=new ChromeDriver(options);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void startRemoteExecution() {
		try 
		{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			String remoteURL=null;
			if(ConfigReader.get("platform").equalsIgnoreCase("Windows")) {
				remoteURL=ConfigReader.get("windowsNodeURL");	
			}
			else if(ConfigReader.get("platform").equalsIgnoreCase("Linux")) {
				remoteURL=ConfigReader.get("LinuxNodeURL");	
			}	
			driver=new RemoteWebDriver(new URL(remoteURL),options);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}