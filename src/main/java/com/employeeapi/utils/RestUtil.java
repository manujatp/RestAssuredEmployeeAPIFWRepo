package com.employeeapi.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtil {
	
	public static String empName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("ManujaRaj"+generatedString);
	}

	public static String empSal() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public static String empAge() {
	String generatedString = RandomStringUtils.randomNumeric(2);
	return generatedString;
}
}
