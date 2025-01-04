package com.googleApp.utilities;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashMap;
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
			System.out.println("Excel Directory = " + testDataPath);
            FileInputStream file = new FileInputStream(testDataPath); 
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheet("HomePage"); 
            int totalRows = sheet.getLastRowNum();
            for(int rowindex = 1; rowindex<=totalRows; rowindex++ ) 
            {
            	int totalColumns = sheet.getRow(rowindex).getLastCellNum();
            	for(int colindex = 0; colindex<totalColumns; colindex++ ) 
                {
            		System.out.print(sheet.getRow(rowindex).getCell(colindex).toString() + "   ");            		
                }
            	System.out.println();
            }
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}