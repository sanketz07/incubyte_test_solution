package com.incubyte.stringcalc.tdd;

public class StringCalculator3 {
	//3. Allow the Add method to handle new lines between numbers (instead of commas).
	
	public static int add(final String numbers) {
	    int returnValue = 0;
	    String[] numbersArray = numbers.split(",|n"); // Added |n to the split regex
	    for (String number : numbersArray) {
	        if (!number.trim().isEmpty()) {
	            returnValue += Integer.parseInt(number.trim());
	        }
	    }
	    return returnValue;
	}
}
