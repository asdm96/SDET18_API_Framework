package com.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PreemptiveAndDigestiveAuthTest {
	@Test
	public void preemptive() {
		given()
			.auth()
			.preemptive().basic("rmgyara", "rmgy@999")
		.when()
		 	.get("http://localhost:8084/login")
		 .then()
		 	.log().all().assertThat().statusCode(202);
	}
    @Test
    public void digestive() {
    	given()
    		.auth()
    		.digest("rmgntra", "rmgy@999")
    	.when()
    		.get("http://localhost:8084/login")
    		.then().log().all().assertThat().statusCode(202);
    }
}
