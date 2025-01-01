package com.googleApp.utilities;

import java.util.HashMap;

public class ConfigReader {

	public static String get(String str) {
		HashMap<String,String> map=Utilities.configRead();
		return (String)map.get(str);
		
	}
	
}
