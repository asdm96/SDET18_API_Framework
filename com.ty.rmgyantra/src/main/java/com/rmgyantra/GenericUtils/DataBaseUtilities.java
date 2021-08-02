package com.rmgyantra.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
/**
 * @author Adarsh
 */
public class DataBaseUtilities {
	static Connection connection=null;
	static ResultSet result;
	/**
	 * @author Adarsh
	 * This method will perform mysql database connection
	 */
	public void connectToDB() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Adarsh
	 * @throws SQLException
	 * This method will perform database close action
	 */
	public void closeDB() throws SQLException {
		connection.close();
	}
	/**
	 * This method will execute the querry and gives the result
	 * @param querry
	 * @return
	 */
	public ResultSet executeQuerry(String querry) {
		try {
			result=connection.createStatement().executeQuery(querry);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}
	/**
	 * 
	 * @param querry
	 * @param columnNumber
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 * This method will verify whether data is present in database or not
	 */
	public String executeQuerryAndGetData(String querry,int columnNumber,String expectedData) throws Throwable {
		boolean flag=false;
		result = connection.createStatement().executeQuery(querry);
		while(result.next()) {
			try {
				if(result.getString(columnNumber).equals(expectedData)) {
					flag=true;
					break;
				}


			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		if(flag) {
			System.out.println(expectedData+"===> Data is verified in the database");
			return expectedData;
		}else {
			System.out.println(expectedData+"===> Data is not available");
			return expectedData;
		} 
	}

}
