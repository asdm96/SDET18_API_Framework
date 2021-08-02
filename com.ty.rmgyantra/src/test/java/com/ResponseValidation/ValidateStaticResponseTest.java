package com.ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ValidateStaticResponseTest {
	@Test
	public void staticResponse() {
		String expectedProjectName="Adarsh";
		
		
		Response response = when()
			.get("http://localhost:8084/projects");
			
		response.then()
			.assertThat()
			.statusCode(200)
			.log().all();
		
		String actualProjectName = response.jsonPath().get("[0].createdBy");
		System.out.println("expected value is:"+expectedProjectName);
		System.out.println("actual value is"+actualProjectName);
		
		Assert.assertEquals(actualProjectName, expectedProjectName);
			
	}
}
