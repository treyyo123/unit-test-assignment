/**
 * 
 */
package com.promineotech;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 
 */
public class TestDemo {

	public int addPositive(int a, int b) {

		if (a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}

	/*
	 * Method takes a string and loops thru each character in the string checking
	 * for numbers. If no numbers are located it will return true, if numbers are
	 * located it well throw the exception "contains numbers".
	 */
	public boolean containsNoNumbers(String string) {

		int i = 0;

		for (i = 0; i < string.length(); i++) {

			if (!Character.isLetter(string.charAt(i))) {

				throw new IllegalArgumentException("contains numbers");
			}
		}

		return true;

	}
	
	public int randomNumberSquared() {
		int randomInt = getRandomInt();
		
		return randomInt * randomInt;
	}
	
	int getRandomInt() {
		Random random = new Random();
		
		return random.nextInt(10) + 1;
	}

}// end of class
