package com.rmgyantra.DifferentWaysToPost;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.rmgyantra.POJOLibrary.POJOClass;

import io.restassured.http.ContentType;

public class POJOClassWithDataProvider {

	@Test(dataProvider = "provideData")
	public void pojoClassWithDataProvider(String createdBy, String projectName, String status, int teamSize) {
		POJOClass pj = new POJOClass(createdBy, projectName, status, teamSize);

		given().contentType(ContentType.JSON).body(pj).when().post("http://localhost:8084/addProject").then().log()
				.all();
	}
	@DataProvider
	public Object[][] provideData() {
		Object[][] obj = new Object[2][4];
		obj[0][0] = "sravan";
		obj[0][1] = "SDET_11_1";
		obj[0][2] = "On-going";
		obj[0][3] = 11;

		obj[1][0] = "sravan";
		obj[1][1] = "SDET_11_2";
		obj[1][2] = "On-going";
		obj[1][3] = 11;
		
		return obj;
	}

}
