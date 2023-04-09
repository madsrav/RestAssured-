package com.rmgyantra.CRUDWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GettinAllProjectsTest {
	@Test
	public void getAllProectsTest()
	{
	  Response response = RestAssured.get("http://localhost:8084/projects");
//	  System.out.println(response.asString());
//	  response.prettyPrint();
//	  int sc = response.getStatusCode();
//		System.out.println(sc);
//		Assert.assertequal(200,sc);
	  ValidatableResponse validres = response.then();
	  validres.statusCode(200);
	  validres.contentType(ContentType.JSON);
	  validres.log().all();	
	}
}
