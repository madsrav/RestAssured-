package com.rmgyantra.DifferentWaysToPost;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class JSONFileTest {
	@Test
	public void jsonFileTest()
	{
		File f= new File("./DATA.json");
		
		given()
		.contentType(ContentType.JSON)
		.body(f)
		.when().post("http://localhost:8084/addProject")
		.then()
		.log().all();	
	}
	

}
