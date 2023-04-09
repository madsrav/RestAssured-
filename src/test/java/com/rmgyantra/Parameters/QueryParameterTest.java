package com.rmgyantra.Parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryParameterTest {
	
	@Test
	public void queryParameter()
	{
		given()
		.pathParam("username","madsrav")
		.queryParam("sort", "created")
		.when().get("https://api.github.com/users/{username}/repos")
		.then().log().all();
	}

}
