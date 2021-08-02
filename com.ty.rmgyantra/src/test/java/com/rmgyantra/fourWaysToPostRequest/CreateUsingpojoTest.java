package com.rmgyantra.fourWaysToPostRequest;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import com.projectpojolibrary.ProjectLib;

import io.restassured.http.ContentType;

public class CreateUsingpojoTest {
	@Test
	public void createpojo() {
		
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		
		ProjectLib pojoObject = new ProjectLib("testyantra", "testyantra_onlines"+randomNumber, "completed", 610);
		given()
		  .contentType(ContentType.JSON)
		  .body(pojoObject)
	    .when()
	       .post("http://localhost:8084/addProject")
	    .then()
	      .log().all()
	      .and()
	      .assertThat().statusCode(201);	
	}

}
