package com.rmgyantra.CrudOperationwithoutbddTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CompleteUpdationTest {
  @Test
  public void updation() {
 JSONObject jobj =new JSONObject();
	  
	 
	  jobj.put("projectName", "Rohan barai updated");
	 
	  
	  

	  RequestSpecification reqspec = RestAssured.given();
	  reqspec.contentType(ContentType.JSON);
	  reqspec.body(jobj);
	  
	  Response response = reqspec.put("http://localhost:8084/projects/TY_PROJ_2802");
	  
	    ValidatableResponse vres = response.then(); 
		/*
		 * vres.assertThat().statusCode(201);
		 * vres.assertThat().contentType("application/json"); vres.log().all();
		 */
	    
	  
  }
}
