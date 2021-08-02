package com.ResponseValidation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.projectpojolibrary.ProjectLib;

import io.restassured.http.ContentType;

public class CreateProjectUsingMultipleDataTest {
	@Test(dataProvider="provideData")
	public void createProject(String createdBy,String projectName,String status,int teamSize) {

		ProjectLib pojoObject = new ProjectLib(createdBy, projectName, status, teamSize);
		given()
		  .contentType(ContentType.JSON)
		  .body(pojoObject)
	    .when()
	       .post("http://localhost:8084/addProject")
	    .then()
	      .log().all()
	      .and()
	      .assertThat().statusCode(201);
	}

@DataProvider
public Object[][] provideData() {
	Object[][] objArray = new Object[3][4];
	
	objArray[0][0]="testyantra123";
	objArray[0][1]="testyantra123_project";
	objArray[0][2]="completed";
	objArray[0][3]=101;
	
	objArray[1][0]="testyantra456";
	objArray[1][1]="testyantra456_project";
	objArray[1][2]="completed";
	objArray[1][3]=202;
	
	objArray[2][0]="testyantra789";
	objArray[2][1]="testyantra789_project";
	objArray[2][2]="completed";
	objArray[2][3]=303;
	
	return objArray;
}
}
