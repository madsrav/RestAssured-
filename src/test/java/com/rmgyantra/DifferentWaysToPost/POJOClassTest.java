package com.rmgyantra.DifferentWaysToPost;

import org.testng.annotations.Test;

import com.rmgyantra.POJOLibrary.POJOClass;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class POJOClassTest {
	
	@Test
	public void pojoTest()
	{
		POJOClass pj= new POJOClass("sravan","SDET__11_rest", "created", 13);
		
		given()
		.contentType(ContentType.JSON)
		.body(pj)
		.when().post("http://localhost:8084/addProject")
		.then().log().all();
	}

}
