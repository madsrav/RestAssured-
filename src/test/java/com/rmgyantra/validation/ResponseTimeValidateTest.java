package com.rmgyantra.validation;


import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import java.util.concurrent.TimeUnit;

public class ResponseTimeValidateTest {
	
	@Test
	public void responseTimeValidateTest()
	{
		 String expProName="SDET_11_TYSS";
		 when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.lessThan(10000L), TimeUnit.MILLISECONDS)
		.assertThat().body("[2].projectName",Matchers.equalTo(expProName))
		.log().all();	
	}
}
