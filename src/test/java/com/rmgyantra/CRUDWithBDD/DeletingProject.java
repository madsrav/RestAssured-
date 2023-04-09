package com.rmgyantra.CRUDWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeletingProject {
	@Test
	public void deletingProject()
	{
		when().delete("http://localhost:8084/projects/TY_PROJ_404")
		.then().assertThat().statusCode(204).log().all();
		
	}

}
