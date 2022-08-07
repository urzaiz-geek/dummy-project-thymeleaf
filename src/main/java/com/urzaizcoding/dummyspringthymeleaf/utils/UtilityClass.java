package com.urzaizcoding.dummyspringthymeleaf.utils;

public class UtilityClass {
	
	public static String capitalize(String word) {
		if(word == null)
			return "";
		return word.substring(0,1).toUpperCase().concat(word.substring(1).toLowerCase());
	}
}
