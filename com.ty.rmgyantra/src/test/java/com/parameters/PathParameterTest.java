package com.parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class PathParameterTest {
	@Test
	public void parameter() {
		String projectId="TY_PROJ_804";
		given()
		.contentType(ContentType.JSON)
			.pathParam("projectId", projectId)
		//here projectId is the variable which holds TY_PROJ_804
		.when()
			.get("http://localhost:8084/projects/{projectId}")
		.then()
			.log().all()
			.assertThat().statusCode(200);
	}

}
