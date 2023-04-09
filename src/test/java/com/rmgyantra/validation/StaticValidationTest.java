package com.rmgyantra.validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

import static io.restassured.RestAssured.*;

public class StaticValidationTest {
	
	@Test
	public void staticValidationTest()
	{
		 String expProName="SDET_11_TYSS";
		 Response rsps = when().get("http://localhost:8084/projects");
	     String actProName = rsps.jsonPath().get("[1].projectName");
	 //  System.out.print(rsps.jsonPath().get("[1]"));
	     Assert.assertEquals(actProName, expProName);	
	    
	}

}
