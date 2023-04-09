package com.rmgyantra.CRUDWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GettingSingleProjectTest {
     @Test
	public void getSingleProjectTest()
	{
		Response response = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1202");
		ValidatableResponse valres = response.then();	
		valres.statusCode(200);
		valres.log().all();
		valres.contentType(ContentType.JSON);
	}

}
