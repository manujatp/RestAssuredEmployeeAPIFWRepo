package com.employeeapi.tests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utils.RestUtil;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;

public class TC004_Put_Employee_Record extends TestBase{
	
	String empName = RestUtil.empName();
	String empSalary = RestUtil.empSal();
	String empAge = RestUtil.empAge();
	
	@BeforeClass
	public void createEmployee() throws InterruptedException {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		 //JSONObject is a class that represents a simple JSON. We can add Key-Value pairs using the put method
		//{"name" : "John123X", "salary":"age":"23"}
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", empName);
		requestParams.put("salary", empSalary);
		requestParams.put("age", empAge);
		
		//Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type","application/json");
		
		//Add the Json to the body of the request
		httpRequest.body(requestParams.toString());
		
		response = httpRequest.request(Method.PUT,"/update/"+empID);
		Thread.sleep(5000);
	}

	@Test
	public void checkResponseBody() {
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		Assert.assertEquals(responseBody.contains(empName), true);
		Assert.assertEquals(responseBody.contains(empSalary), true);
		Assert.assertEquals(responseBody.contains(empAge), true);
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
