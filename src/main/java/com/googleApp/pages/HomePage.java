package com.googleApp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.googleApp.driver.Driver;
import com.googleApp.driver.DriverManager;
import com.googleApp.reports.Logger;
//import com.relevantcodes.extentreports.ExtentTest;

public class HomePage {

	@FindBy(xpath=".//img[@alt='Google']")
	WebElement homePageLogo;
	
	@FindBy(xpath=".//*[@name='q']")
	WebElement searchBox;
	
	public HomePage(){
		PageFactory.initElements(DriverManager.getDriver(),this);	
	}
	
	public void homePageTitleValidation() throws Exception{
		Logger.logINFO("Verifying the homepage");
		Thread.sleep(3000);
		Assert.assertTrue(searchBox.isDisplayed(),"Home page is not displayed");
	}
	
	public void searchBoxValidation() throws Exception{
		Logger.logINFO("Verifying the search box validation");
		Thread.sleep(3000);
		searchBox.sendKeys("Selenium");
		String searchText=searchBox.getAttribute("value");
		Assert.assertTrue(searchText.equalsIgnoreCase("Selenium"),"search box text is not matching");
	}
}