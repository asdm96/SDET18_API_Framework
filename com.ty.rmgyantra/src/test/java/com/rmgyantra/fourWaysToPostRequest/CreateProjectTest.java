package com.rmgyantra.fourWaysToPostRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectTest {
	@Test
	public void create() {

		Random random = new Random();
		int randomNumber = random.nextInt(2000);
		System.out.println(randomNumber);

		JSONObject jobj =new JSONObject();

		jobj.put("createdBy", "online batch"); 
		jobj.put("projectName","suparna_paul"+randomNumber+""); 
		jobj.put("status", "on-going"); 
		jobj.put("teamSize", 100);
		

				given() 
				.contentType(ContentType.JSON) 
				.body(jobj) 
				.when()
				.post("http://localhost:8084/addProject") 
				.then() 
				.log().all() .and()
				.assertThat().contentType("application/json");

	}

}
