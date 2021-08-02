package com.rmgyantra.CrudOperationwithbddTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CompleteUpdateTest {
	@Test
	public void update() {
		
	
		JSONObject jobj =new JSONObject();
		  
		  jobj.put("createdBy", "online batch");
		  jobj.put("projectName", "Adarsh_M");
		  jobj.put("status", "on-going");
		  jobj.put("teamSize", 300);
		  
		  given()
		  	.contentType(ContentType.JSON)
		  	.body(jobj)
		  .when()
		  	.put("http://localhost:8084/projects/TY_PROJ_804")
		  .then().log().all();
		 
  
	}

}
