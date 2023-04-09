package com.rmgyantra.Requestchaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class RequestChainingTest {
	
	@Test
	public void requestChainingTest()
	{
//		JSONObject jobj= new JSONObject();
//		jobj.put("createdBy","Sravan");
//    	jobj.put("projectName","Sdet_Rest_Assue_BDD");
//    	jobj.put("status", "on-going");
//    	jobj.put("teamSize", 111);
//    	
//    	String proId=given().contentType(ContentType.JSON).body(jobj)
//    	.when().post("http://localhost:8084/addProject").jsonPath().get("projectId");
//    	System.out.println(proId);
//    	given().pathParam("projtId", proId)
//		.when().get("http://localhost:8084/projects/{projtId}")
//    	.then().statusCode(200).log().all();
//    	
//    	given().pathParam("projtId", proId)
//    	.when().delete("http://localhost:8084/projects/{projtId}")
//    	.then().statusCode(204).log().body();
		
    	Response rsps = when().get("http://localhost:8084/projects");
    	String proId=rsps.jsonPath().get("[0].projectId");
    	
    	         given().pathParam("projectId", proId)
    			.when().delete("http://localhost:8084/projects/{projectId}")
    			.then().assertThat().statusCode(204).log().all();
		
	}
	
	

}
