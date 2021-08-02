package com.parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParameterUSingGitTest {
	@Test
	public void paramter() {
	   given()
	   	.contentType(ContentType.JSON)
	   	.pathParam("username", "adarshmgit")
	   	.queryParam("sort", "created")
	   .when()
	   	.get("https://api.github.com/users/{username}/repos")
	  .then()
	  	.log().all();
		
	}

}
