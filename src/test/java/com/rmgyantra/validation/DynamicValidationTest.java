package com.rmgyantra.validation;


import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicValidationTest {
	
	@Test()
	public void dynamicValidation()
	{
		String expProName="TY_PROJ_1008";
		
		Response rsps = when().get("http://localhost:8084/projects");
		List<String> actList = rsps.jsonPath().get("projectName");
		System.out.println(actList.size());
		
		for(int i=0;i<actList.size();i++)
		 {	
			String actProName=actList.get(i);
			if(actProName.equals(expProName))
			{	
				System.out.println(rsps.jsonPath().get("["+i+"]"));
				System.out.println("project name is availble");
				break;
			}
		}	
	}
}
