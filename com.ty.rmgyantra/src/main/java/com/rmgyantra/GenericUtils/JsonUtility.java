package com.rmgyantra.GenericUtils;

import io.restassured.response.Response;
/**
 * 
 * @author asd
 *
 */
public class JsonUtility {
	/**
	 * method will give the data according to the json path passed
	 * @param jsonPath
	 * @param response
	 * @return
	 */
	public String getJsonPathData(String jsonPath,Response response) {
		String result=response.jsonPath().get(jsonPath);
		return result;
		

	}

}
