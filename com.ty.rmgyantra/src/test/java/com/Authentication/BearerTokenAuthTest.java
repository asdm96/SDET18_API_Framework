package com.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenAuthTest {
	@Test
	public void beraerToken() {
		given()
			.auth().oauth2("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")
		.when()
			.get("https://api.github.com/user/repos")
		.then().log().all();
	}

}
