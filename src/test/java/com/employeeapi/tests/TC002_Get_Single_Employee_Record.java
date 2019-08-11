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

public class TC002_Get_Single_Employee_Record extends TestBase {
	
	@BeforeClass
	public void getEmployeeData() throws InterruptedException {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employee/"+empID);
		Thread.sleep(3000);
	}
	
	@Test
	public void checkResponseBody() {
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		Assert.assertEquals(responseBody.contains(empID), true);
	}
	
	@Test
	public void checkStatusCode() {
		int statusCode = response.getStatusCode();
		System.out.println("Status Code : "+statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void checkStatusLine() {
		String statusLine = response.getStatusLine();
		System.out.println("Status Line : "+statusLine);
		//Assert.assertEquals(statusLine, "");
	}

	@Test
	public void checkHeader() {
		
		Headers allHeader = response.headers();
		
		for(Header header : allHeader) {
			System.out.println(header.getName()+" "+header.getValue());
		}
		
		String contentType = response.header("Content-Type");
		System.out.println("Content Type : "+contentType);
		
		String contentEncoding = response.header("Content-Encoding");
		System.out.println("Content-Encoding : "+contentEncoding);
	}
}
