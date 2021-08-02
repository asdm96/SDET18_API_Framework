package com.rmgyantra.CrudOperationwithoutbddTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
/**
 * this script will create a project
 * @author Adarsh
 *
 */
public class CreateAProjectTest {
  @Test
  public void createProject() {
	  
	  JSONObject jobj =new JSONObject();
	  
	  jobj.put("createdBy", "online batch");
	  jobj.put("projectName", "Rohan barai");
	  jobj.put("status", "on-going");
	  jobj.put("teamSize", 17);
	  
	 

	  RequestSpecification reqspec = RestAssured.given();
	  reqspec.contentType(ContentType.JSON);
	  reqspec.body(jobj);
	  
	  Response response = reqspec.post("http://localhost:8084/addProject");
	  
	    ValidatableResponse vres = response.then(); 
	    vres.assertThat().statusCode(201);
	    vres.assertThat().contentType("application/json");
	    vres.log().all();
	    
	  
  }
}
