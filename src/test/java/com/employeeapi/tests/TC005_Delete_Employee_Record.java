package com.employeeapi.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC005_Delete_Employee_Record extends TestBase{
	
	@BeforeClass
	public void deleteEmployee() throws InterruptedException {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		
		response = httpRequest.request(Method.GET, "/employees");
		//First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		//Capture id
		String empId = jsonPathEvaluator.get("[0].id");
		response = httpRequest.request(Method.DELETE, "/delete/"+empID);//Pass ID to delete record
		
		Thread.sleep(3000);
	}
	
	@Test
	public void checkResponseBody() {
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is : "+responseBody);
		Assert.assertEquals(responseBody.contains("successfully! deleted records"), true);
		
	}

}
