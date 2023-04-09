package dataBase.practice;




import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgyantra.POJOLibrary.POJOClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Practice {
	
	
	@Test(dataProvider = "getData")
	public void pracice(String createdBy, String projectName, String status, int teamSize)
	{
		POJOClass pj=new POJOClass(createdBy,projectName,status,teamSize);
		
		given().contentType(ContentType.JSON)
		.body(pj)
		.when().post("http://localhost:8084/addProject")
		.then().log().all();
	}
		@DataProvider
		public Object[][] getData()
		{
			Object[][] obj=new Object[2][4];	
			obj[0][0]="jhhdhfh";
			obj[0][1]="ggsgj";
			obj[0][2]="hgbggj";
			obj[0][3]=12;
			
			
			obj[1][0]="jhhhcdhfh";
			obj[1][1]="ggsdgj";
			obj[1][2]="hgbggj";
			obj[1][3]=12;
		return obj;
		}
	

	
		
	

	

}
