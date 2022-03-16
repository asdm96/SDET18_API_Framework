package com.rmgyantra.fourWaysToPostRequest;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;

public class CreateProjectDummi {
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