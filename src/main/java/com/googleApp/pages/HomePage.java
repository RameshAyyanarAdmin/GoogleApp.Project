package com.googleApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.googleApp.driver.DriverManager;
import com.googleApp.reports.Logger;
import com.googleApp.utilities.TestDataReader;
import com.googleApp.utilities.Utilities;


public class HomePage {

	@FindBy(xpath=".//img[@alt='Google']")
	WebElement homePageLogo;
	
	@FindBy(xpath="//textarea[@name='q']")
	WebElement searchBox;

	
	public HomePage(){
		PageFactory.initElements(DriverManager.getDriver(),this);	
		Utilities.setCurrentClassName(this.getClass().getSimpleName());		
	}	
	
	public void homePageTitleValidation() throws Exception{
		Logger.logINFO("Verifying the homepage");
		Thread.sleep(3000);
		Assert.assertTrue(searchBox.isDisplayed(),"Home page is not displayed");
	}
	
	public void searchBoxValidation() throws Exception{
		try 
		{			
			Logger.logINFO("Verifying the search box validation");
			Thread.sleep(3000);
			((JavascriptExecutor)DriverManager.getDriver()).executeScript("arguments[0].style.border='3px solid green'",searchBox);
			Thread.sleep(3000);
			searchBox.sendKeys(TestDataReader.fetch("Search_InputText")); 
			Thread.sleep(2000);
			String searchText=searchBox.getAttribute("value");
			Assert.assertTrue(searchText.equalsIgnoreCase(TestDataReader.fetch("Expected Result")),"search box text is not matching");			
		}
		catch(Exception e) {
			e.printStackTrace();
			Logger.logFAIL("search Box Validation failed with exception \n" + e.getMessage());
			Assert.assertTrue(false, "Failed with exception \n" + e.getMessage());			
		}
	}
}