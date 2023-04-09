package com.rmgyantra.CRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdatingProjectTest {
	
	@Test
	public void updatingProjectTest()
	{
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy","SRAVAN");
    	jobj.put("projectName","SDET_11_RestAssured");
    	jobj.put("status", "completed");
    	jobj.put("teamSize", 11);
    	
    	RequestSpecification resspec = RestAssured.given();
    	resspec.contentType(ContentType.JSON);
    	resspec.body(jobj);
    	
    	Response res = resspec.put("http://localhost:8084/projects/TY_PROJ_1402");
    	ValidatableResponse valres = res.then();
    	valres.statusCode(200);
    	valres.log().body();	
	}

}
