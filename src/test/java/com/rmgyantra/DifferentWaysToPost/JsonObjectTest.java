package com.rmgyantra.DifferentWaysToPost;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class JsonObjectTest {
	
	
	@Test
	public void jsonObjectTest()
	{
			JSONObject jobj= new JSONObject();
			jobj.put("createdBy","SRAVAN");
	    	jobj.put("projectName","SDET_RestAssured_BDD");
	    	jobj.put("status", "created");
	    	jobj.put("teamSize", 21);
			
			given()
			.contentType(ContentType.JSON)
			.body(jobj)
			.when().post("http://localhost:8084/addProject")
			.then()
			.assertThat().statusCode(201)
			.log().all();	
		}
		
	}
