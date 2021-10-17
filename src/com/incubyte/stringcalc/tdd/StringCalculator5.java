package com.incubyte.stringcalc.tdd;

import java.util.ArrayList;
import java.util.List;
//Calling Add with a negative number will throw an exception “negatives not allowed”and the negative that was passed.
//If there are multiple negatives, show all of them in the exception message

public class StringCalculator5{
public static int add(final String numbers, final String delimiter) {
    int returnValue = 0;
    String[] numbersArray = numbers.split(delimiter);
    List<Integer> negativeNumbers = new ArrayList<Integer>();
    for (String number : numbersArray) {
        if (!number.trim().isEmpty()) {
            int numberInt = Integer.parseInt(number.trim());
            if (numberInt < 0) {
                negativeNumbers.add(numberInt);
            }
            returnValue += numberInt;
        }
    }
    if (negativeNumbers.size() > 0) {
        throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
    }
    return returnValue;     
}


}
