package com.rmgyantra.Parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathParameterTest {

	@Test
	public void pathParameter()
	{
		given()
		.pathParam("ProjectId","TY_PROJ_1004")
		.when()
		.get("http://localhost:8084/projects/{ProjectId}")
		.then().assertThat().statusCode(200).log().all();
		
	}
}
