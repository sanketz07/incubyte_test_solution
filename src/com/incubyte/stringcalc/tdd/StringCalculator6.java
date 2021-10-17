package com.incubyte.stringcalc.tdd;

import java.util.ArrayList;
import java.util.List;
//9. Numbers bigger than 1000 should be ignored, for example:
public class StringCalculator6 {
	
	
	public static int add(final String numbers, final String delimiter) {
        int returnValue = 0;
        String[] numbersArray = numbers.split(delimiter);
        
      List<Integer> negativeNumbers = new ArrayList<Integer>();
        for (String number : numbersArray) {
                if (!number.trim().isEmpty()) {
                        int numberInt = Integer.parseInt(number.trim());
                        if (numberInt < 0) {
                                negativeNumbers.add(numberInt);
                        } else if (numberInt <= 1000) {
                                returnValue += numberInt;
                        }
                }
        }
        if (negativeNumbers.size() > 0) {
                throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
        }
        return returnValue;                
}

	
}
