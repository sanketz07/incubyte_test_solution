package com.incubyte.stringcalc.tdd;

public class StringCalculator7 {
	
	//(for an empty string it will return 0
	
	public static final int add(final String numbers) { // Changed void to int
	    String[] numbersArray = numbers.split(",");
	    if (numbersArray.length > 2) {
	        throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
	    } else {
	        for (String number : numbersArray) {
	            if (!number.isEmpty()) {
	                Integer.parseInt(number);
	            }
	        }
	    }
	    return 0; // Added return
	}
}
