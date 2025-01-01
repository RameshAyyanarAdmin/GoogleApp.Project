package com.googleApp.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.googleApp.constants.Constants;

public class Utilities {
	
	public static HashMap<String,String> propHashMap;
	
	public static void config() {
		FileReader reader;
		Properties prop=null;
		try {
			reader = new FileReader(Constants.configPropertyFile+"config.properties");
			prop=new Properties();
			prop.load(reader);
			propHashMap=new HashMap<String,String>();
		    for (Map.Entry<Object, Object> entry : prop.entrySet()) {
		    	propHashMap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
		
	public static HashMap<String,String> configRead()
	{
		return propHashMap;	
	}
}
