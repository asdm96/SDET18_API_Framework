package com.parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QuerryParameterTest {
	@Test
	public void parameter() {
		given()
			.queryParam("page", "2")
		.when()
			.get("https://reqres.in/api/users")
		.then()
			.log().all();
		
	}

}
