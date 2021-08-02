package com.rmgyantra.fourWaysToPostRequest;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingHashMapTest {
	@Test
	public void createSuingmap() {

		//create a object for hashmap
		HashMap map = new HashMap();
		
		map.put("createdBy", "online batch");
		map.put("projectName", "suparna_paul-update");
		map.put("status", "on-going");
		map.put("teamSize", 10000);

		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()	
		.post("http://localhost:8084/addProject")
		.then()
		.log().all()
		.and()
		.assertThat().contentType("application/json");

	}
}
