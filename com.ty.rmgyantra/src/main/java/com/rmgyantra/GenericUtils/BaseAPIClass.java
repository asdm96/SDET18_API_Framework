package com.rmgyantra.GenericUtils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

/**
 * 
 * @author Adarsh
 *
 */
public class BaseAPIClass {
	DataBaseUtilities db = new DataBaseUtilities();
	@BeforeSuite
	public void configBeforeSuite() {
		System.out.println("=====start=====");
		db.connectToDB();
		System.out.println("===connected to database===");
		baseURI="http://localhost";
		port=8084;
	}
	@AfterSuite
	public void configAfterSuite() throws Throwable {
		db.closeDB();
		System.out.println("====database is closed======");
	}
}
