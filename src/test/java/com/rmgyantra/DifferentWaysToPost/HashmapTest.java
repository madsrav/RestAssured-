package com.rmgyantra.DifferentWaysToPost;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class HashmapTest {
	@Test
	public void hashmapTest()
	{
			HashMap hp = new HashMap();
			hp.put("createdBy","SRAVAN");
	    	hp.put("projectName","SDET_11_Rest_Assured_BDD");
	    	hp.put("status", "created");
	    	hp.put("teamSize", 21);
			
			
			given()
			.contentType(ContentType.JSON)
			.body(hp)
			.when().post("http://localhost:8084/addProject")
			.then()
			.assertThat().statusCode(201)
			.log().all();	
		}
	}