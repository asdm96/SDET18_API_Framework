package com.rmgyantra.CrudOperationwithbddTest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteProjectTest {
	@Test
	public void deleteprojects() {
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_2802")
		.then()
			.assertThat().statusCode(204)
			.and()
			.log().all();
	}

}
