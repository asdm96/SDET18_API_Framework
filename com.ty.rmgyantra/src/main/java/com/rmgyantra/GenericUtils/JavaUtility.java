package com.rmgyantra.GenericUtils;

import java.util.Random;
/**
 * 
 * @author asd
 *
 */
public class JavaUtility {
	
	/**
	 * This method will generate a random number
	 * @author Adarsh
	 * @return
	 */
	public int randomNumber() {
		Random random = new Random();
		int randomData=random.nextInt(5000);
		return randomData;
	}

}
