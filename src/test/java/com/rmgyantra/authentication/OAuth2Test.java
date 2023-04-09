package com.rmgyantra.authentication;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuth2Test {

	@Test
	public void oauth2Test() {
		Response rsps = given().formParam("client_id", "SDET_11_RestAssured")
				.formParam("client_secret", "a6f610384b9f4699174dbe912a0cec62")
				.formParam("grant_type", "client_credentials").
				formParam("redirect_uri", "https://example.com").
				when()
				.post("http://coop.apps.symfonycasts.com/token");

		String token = rsps.jsonPath().get("access_token");
		System.out.println(token);

		given()
		.auth().
		oauth2(token).
		pathParam("USER_ID", "4307").
		when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed").then().log().body();

	}
}