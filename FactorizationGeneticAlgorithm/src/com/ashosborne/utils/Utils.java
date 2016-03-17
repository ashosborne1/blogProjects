package com.ashosborne.utils;

import java.util.Random;

/**
 * Utility class with commonly used methods
 * @author Ashley Osborne
 *
 */
public class Utils {

	/**
	 * Roll a fifty percent chance spin 
	 * @return True if the spin was successful
	 */
	public static boolean fiftyPercentSpin(){
		Random rand = new Random();
		if(rand.nextInt(100) <= 50){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Roll a five percent chance spin
	 * @return True if the spin was successful
	 */
	public static boolean fivePercentSpin(){
		Random rand = new Random();
		if(rand.nextInt(100) <= 5){
			return true;
		}else{
			return false;
		}
	}
}