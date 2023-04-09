package com.rmgyantra.CRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatingProjectTest {
	@Test
	public void creatingProject()
	{
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy","SRAVAN");
    	jobj.put("projectName","SDET_11_RestAssured_BDD");
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
