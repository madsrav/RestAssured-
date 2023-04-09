package com.rmgyantra.authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTest {
	
	@Test
	public void bearerTokenTest()
	{
		
		given().auth().oauth2("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")
		.when().get("https://api.github.com/user/repos")
		.then().statusCode(200).log().body();
	}

}
