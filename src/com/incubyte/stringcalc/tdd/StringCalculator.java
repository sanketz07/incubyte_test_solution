package com.incubyte.stringcalc.tdd;
/*1. In a test-first manner, create a simple class class StringCalculator
with a method public int Add(string numbers)
1. The method can take 0, 1 or 2 numbers, and will return their sum
(for an empty string it will return 0)
for example
“” == 0 , “1” == 1 , “1,2” == 3
2. Start with the simplest test case of an empty string and move to one & two
numbers
3. Remember to solve things as simply as possible so that you force yourself to
write tests you did not think about
*/

public class StringCalculator {
	public static final void add(final String numbers) {
        String[] numbersArray = numbers.split(",");
        if (numbersArray.length > 2) {
            throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
        } else {
            for (String number : numbersArray) {
                Integer.parseInt(number); // If it is not a number, parseInt will throw an exception
            }
        }
    }
	
	
}
