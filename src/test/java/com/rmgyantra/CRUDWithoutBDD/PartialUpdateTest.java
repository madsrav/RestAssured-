package com.rmgyantra.CRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PartialUpdateTest {
	@Test
	public void createUser()
	{
		
    	JSONObject jobj= new JSONObject();
    	jobj.put("name","SRAVAN");
    	jobj.put("job","engineer");
   
    	
    	RequestSpecification reqspec = RestAssured.given();
    	reqspec.contentType(ContentType.JSON);
    	reqspec.body(jobj);
    	
    	Response res = reqspec.post("https://reqres.in/api/users");
    	ValidatableResponse validres = res.then();
    	validres.statusCode(201);
    	validres.log().all(); 	
	}
	@Test
	public void partialUpdateTest()
	{
		JSONObject jobj= new JSONObject();
		//jobj.put("name","SRAVAN");
    	jobj.put("job","SOFTWARE Engineer");
   
    	
    	RequestSpecification resspec = RestAssured.given();
    	resspec.contentType(ContentType.JSON);
    	resspec.body(jobj);
    	
    	Response res = resspec.patch("https://reqres.in/api/users/2");
    	ValidatableResponse valres = res.then();
    	valres.statusCode(200);
    	valres.log().body();			
	}
}
