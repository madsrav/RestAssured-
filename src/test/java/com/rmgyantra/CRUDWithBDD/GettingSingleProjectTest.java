package com.rmgyantra.CRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GettingSingleProjectTest {
	@Test
	public void gettingSingleProject()
	{
		when().get("http://localhost:8084/projects/TY_PROJ_404")
		.then().assertThat().statusCode(200)
		.log().all();	
	}

}
