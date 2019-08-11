package com.employeeapi.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;

public class TC001_Get_All_Employees extends TestBase {
	
	@BeforeClass
	public void getAllEmployees() throws InterruptedException {
		logger.info("****Started TC001_Get_All_Employees*****");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1"; 
	    httpRequest = RestAssured.given();
	    response = httpRequest.request(Method.GET, "/employees");
	    
	    Thread.sleep(3000);
	}

	@Test
	public void checkResponseBody() {
		logger.info("Checking Response Body");
		String responseBody = response.getBody().asString();
        logger.info("Response Body is : "+responseBody);
        System.out.println("Response Body is : "+responseBody);
        Assert.assertTrue(responseBody!=null);
		
	}
	
	@Test
	public void checkStatusCode() {
		logger.info("Checking the Status Code");
		int statusCode = response.getStatusCode();
		logger.info("Status Code is : "+statusCode);
		System.out.println("Status Code is : "+statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void checkStatusLine() {
		logger.info("Checking status line");
		String statusLine = response.getStatusLine();
		logger.info("Status Line is : "+statusLine);
		System.out.println("Status Line is : "+statusLine);
		//Assert.assertEquals(statusLine, "");
		}
	
	@Test 
	public void checkHeader() {
		
		Headers allHeaders = response.headers();
		
		for(Header header : allHeaders) {
			System.out.println(header.getName()+" "+header.getValue());
		}
		
		
	}
}
