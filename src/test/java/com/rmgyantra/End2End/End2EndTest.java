package com.rmgyantra.End2End;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.rmgyantra.GenericUtils.BaseAPI;
import com.rmgyantra.GenericUtils.EndPoints;
import com.rmgyantra.GenericUtils.JavaUtility;
import com.rmgyantra.POJOLibrary.POJOClass;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class End2EndTest extends BaseAPI {

	@Test()
	public void end2End() throws Throwable {
		POJOClass pj = new POJOClass("sravan", "reqestChainig"+JavaUtility.javautility(), "created", 15);
		
		baseURI="http://localhost:8084";
		port=8084;
		
		String proid = given().contentType(ContentType.JSON).body(pj).when().post(EndPoints.addingProject)
				.jsonPath().get("projectId");
		System.out.println(proid);
		String name = given().pathParam("projectId", proid).when().get(EndPoints.gettingSingleProject)
				.jsonPath().get("projectName");
		System.out.println(name);

		ResultSet result = dutils.executeQuery("select* from project;");
		while (result.next()) {
			if (name.equals(result.getString(4))) {
				System.out.println(name + " is availble");
				break;
			}
		}
	}

}
