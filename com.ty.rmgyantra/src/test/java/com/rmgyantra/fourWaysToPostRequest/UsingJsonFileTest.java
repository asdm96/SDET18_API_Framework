package com.rmgyantra.fourWaysToPostRequest;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
/**
 * Description: create a project with json
 * @author Adarsh
 *
 */
public class UsingJsonFileTest {
	@Test
	public void jsonFileCreate() {

		 File file = new File("./datas.json");
		 given() 
			.contentType(ContentType.JSON) 
			.body(file) 
		.when()
			.post("http://localhost:8084/addProject") 
		.then() 
			.log().all() .and()
			.assertThat().contentType("application/json");

	}

}
