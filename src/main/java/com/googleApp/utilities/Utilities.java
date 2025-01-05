package com.googleApp.utilities;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;


import com.googleApp.constants.Constants;

public class Utilities {

	public static HashMap<String, String> propHashMap;

	public static void config() {
		FileReader reader;
		Properties prop = null;
		try {
			reader = new FileReader(Constants.configPropertyFile + "config.properties");
			prop = new Properties();
			prop.load(reader);
			HashMap<String, String> propertyHashMap = new HashMap<String, String>();
			for (Map.Entry<Object, Object> entry : prop.entrySet()) {
				propertyHashMap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
			}
			setConfig(propertyHashMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(false,e.getMessage());
		}
	}
	
	public static void setConfig(HashMap<String, String> propertyHashMap) {
		propHashMap = propertyHashMap;
	}
	
	public static HashMap<String, String> getConfig() {
		return propHashMap;
	}

	public static void FetchExcelTestData() {
		try 
		{
			String testDataPath = System.getProperty("user.dir") + ConfigReader.get("testDataPath");
			FileInputStream file = new FileInputStream(testDataPath);
			Workbook workbook = WorkbookFactory.create(file);			
			LinkedHashMap<String,LinkedHashMap<String, LinkedHashMap<String, String>>> sheetCollection = new LinkedHashMap<>();
			String sheetNameKey = "";
			LinkedHashMap<String, LinkedHashMap<String, String>> TableValueCollection;						
			for (int index = 0; index < workbook.getNumberOfSheets(); index++) 
			{				
				LinkedHashMap<String, String> rowValueCollection;
				String rowTestCaseKey = "";
				sheetNameKey = workbook.getSheetName(index);
				Sheet sheet = workbook.getSheet(sheetNameKey);
				TableValueCollection = new LinkedHashMap<>();
				int totalRows = sheet.getLastRowNum();
				for (int rowindex = 1; rowindex <= totalRows; rowindex++) 
				{
					rowTestCaseKey = sheet.getRow(rowindex).getCell(0).toString();
					rowValueCollection = new LinkedHashMap<>();
					int totalColumns = sheet.getRow(rowindex).getLastCellNum();
					for (int colindex = 1; colindex < totalColumns; colindex++) {
						String colKey = sheet.getRow(0).getCell(colindex).toString();
						String colValue = sheet.getRow(rowindex).getCell(colindex).toString();
						rowValueCollection.put(colKey, colValue);
					}
					TableValueCollection.put(rowTestCaseKey, rowValueCollection);
				}
				sheetCollection.put(sheetNameKey, TableValueCollection);	
			}							
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}