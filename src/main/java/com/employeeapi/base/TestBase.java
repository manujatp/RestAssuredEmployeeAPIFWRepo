package com.employeeapi.base;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID = "15379";
	public Logger logger =  LogManager.getLogger(TestBase.class);
	

	

}
