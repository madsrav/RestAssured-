package com.rmgyantra.CRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreatingNewProjectTest {
	@SuppressWarnings("unchecked")
	@Test
	public void creatingNewProjectTest() {

		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "SRAVAN");
		jobj.put("projectName", "SDET_11_RestAssured");
		jobj.put("status", "created");
		jobj.put("teamSize", 11);

		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jobj);

		Response res = reqspec.post("http://localhost:8084/addProject");
		ValidatableResponse validres = res.then();
		//res.body();
		validres.statusCode(201);
		validres.log().all();
		

	}
}
