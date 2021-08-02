package com.rmgyantra.CrudOperationwithoutbddTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProjectTest {
	@Test
	public void deleteProject() {
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_805");
		
		ValidatableResponse vresponse = response.then();
		vresponse.assertThat().contentType("application/json");
		vresponse.assertThat().statusCode(204);
		vresponse.log().all();
		
	}

}
