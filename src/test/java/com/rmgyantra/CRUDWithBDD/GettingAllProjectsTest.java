package com.rmgyantra.CRUDWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GettingAllProjectsTest {
	@Test
	public void gettingAllProjects()
	{
	  when().get("http://localhost:8084/projects")
	  .then()
	  .assertThat().statusCode(200)
	  .log().all();	
	}

}
