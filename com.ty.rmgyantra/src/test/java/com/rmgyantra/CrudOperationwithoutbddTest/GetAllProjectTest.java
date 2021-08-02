package com.rmgyantra.CrudOperationwithoutbddTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllProjectTest {
	@Test
	public void getallProject() {
		
		Response response = RestAssured.get("http://localhost:8084/projects");
		//System.out.println(response.asString());
		//response.prettyPrint();
		
		System.out.println(response.getContentType());
	
		System.out.println(response.getTime());
		
		/*
		 * int actualstatuscode=response.getStatusCode();
		 * Assert.assertEquals(actualstatuscode, 204);
		 */
		
		ValidatableResponse vresponse = response.then();
		vresponse.assertThat().statusCode(200);
		vresponse.assertThat().contentType("application/json");
		vresponse.log().all();
		
	}
}
