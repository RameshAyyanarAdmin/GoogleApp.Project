package com.googleApp.utilities;

import java.util.LinkedHashMap;

public class TestDataReader 
{	
	public static String fetch(String columnName) 
	{
		String returnString = null;
		try 
		{
			LinkedHashMap<String,LinkedHashMap<String, LinkedHashMap<String, String>>> sheetCollection = Utilities.getTestDataCollection();
			String sheetName = Utilities.getCurrentClassName();
			String TestCaseRowKey = Utilities.getCurrentTestName();			
			for (String sheet : sheetCollection.keySet()) 
			{
	            //System.out.println("Key: " + sheet + ", Value: " + sheetCollection.get(sheet));
	            if(sheet.equalsIgnoreCase(sheetName)) {	            	
	            	LinkedHashMap<String, LinkedHashMap<String, String>> sheet1 = sheetCollection.get(sheet);
	            	for (String RowKey : sheet1.keySet()) 
	    			{
	            		 //System.out.println("Key: " + RowKey + ", Value: " + sheet1.get(RowKey));
	            		 if(RowKey.equalsIgnoreCase(TestCaseRowKey))
	            		 {
	            			 LinkedHashMap<String, String> rowCollection = sheet1.get(RowKey); 
	            			 for (String CellKey : rowCollection.keySet()) 
	     	    			{
	            				 //System.out.println("Key: " + CellKey + ", Value: " + rowCollection.get(CellKey));
	            				 if(CellKey.equalsIgnoreCase(columnName)) 
	            				 {
	            					 returnString = rowCollection.get(CellKey); 
	            				 }
	     	    			}
	            		 }
	    			}
	            }
	        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return returnString;
	}	
}