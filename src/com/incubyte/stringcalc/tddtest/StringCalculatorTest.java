package com.incubyte.stringcalc.tddtest;
import org.junit.Assert;
import org.junit.Test;
import com.incubyte.stringcalc.tdd.StringCalculator;
import com.incubyte.stringcalc.tdd.StringCalculator2;
import com.incubyte.stringcalc.tdd.StringCalculator3;
import com.incubyte.stringcalc.tdd.StringCalculator4;
import com.incubyte.stringcalc.tdd.StringCalculator5;
import com.incubyte.stringcalc.tdd.StringCalculator6;
import com.incubyte.stringcalc.tdd.StringCalculator7;

public class StringCalculatorTest {
	//1
	@Test(expected = RuntimeException.class)
    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
        StringCalculator.add("1,2,3");
    }
    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
       
    	StringCalculator.add("1,2");
        Assert.assertTrue(true);
    }
    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        StringCalculator.add("1,X");
    }

//2 Allow the Add method to handle an unknown amount of numbers
    @Test
    public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
        Assert.assertEquals(3+6+15+18+46+33, StringCalculator2.add("3,6,15,18,46,33"));
    }
   
    //3. Allow the Add method to handle new lines between numbers (instead of commas).
    
    @Test
    public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
        Assert.assertEquals(3+6+15, StringCalculator3.add("3,6n15"));
    }
    
    
    //4 Support different delimiters:to change a delimiter, the beginning of the string will contain a separate line
   
    @Test
    public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
        Assert.assertEquals(3+6+15, StringCalculator4.add("//;n3;6;15"));
    }
   
    
    //5 Calling Add with a negative number will throw an exception “negatives not allowed” and the negative that was passed.
   
    
    @Test(expected = RuntimeException.class)
    public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
        StringCalculator5.add("3,-6,15,18,46,33",",");
    }
    //6 If there are multiple negatives, show all of them in the exception message
    @Test
    public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
        RuntimeException exception = null;
        try {
            StringCalculator5.add("3,-6,15,-18,46,33",",");
        } catch (RuntimeException e) {
            exception = e;
        }
        Assert.assertNotNull(exception);
        Assert.assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
    }
    //9. Numbers bigger than 1000 should be ignored, for example:
    @Test
    public final void whenOneOrMoreNumbersAreGreaterThan1000IsUsedThenItIsNotIncludedInSum() {
        Assert.assertEquals(3+1000+6, StringCalculator6.add("3,1000,1001,6,1234",","));
    }
    //10 for an empty string it will return 0
    @Test
    public final void whenEmptyStringIsUsedThenReturnValueIs0() {
        Assert.assertEquals(0, StringCalculator7.add(""));
    }
}