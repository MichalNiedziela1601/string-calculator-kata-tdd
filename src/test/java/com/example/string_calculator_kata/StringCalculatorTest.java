package com.example.string_calculator_kata;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new StringCalculator();
    }

    @Test
    public void givenEmptyStringThenReturnZero() {
        String input = "";
        int expectedResult = 0;
        int result = calculator.add(input);
        assertEquals(expectedResult,result);
    }

    @Test
    public void givenSingleNumberThenReturnValue() {
        String input = "12";
        int expectedResult = 12;
        int result = calculator.add(input);
        assertEquals(expectedResult,result);
    }

    @Test
    public void givenTwoNumbersWithCommaDelimiterThenReturnSumOfThisNumbers() {
        String input = "12,34";
        int expectedResult = 12 + 34;
        int result = calculator.add(input);
        assertEquals(expectedResult,result);
    }

    @Test
    public void givenTwoNumbersWithNewLineDelimiterThenReturnSumOfThisNumbers() {
        String input = "12\n45";
        int expectedResult = 12 + 45;
        int result = calculator.add(input);
        assertEquals(expectedResult,result);
    }

    @Test
    public void givenThreeNumbersWithDelimitersThenReturnSumOfThisNumbers() {
        String input = "12,34\n67";
        int expectedResult = 12 + 34 + 67;
        int result = calculator.add(input);
        assertEquals(expectedResult,result);
    }

    @Test
    public void givenNegativeNumberThenThrowException() {
        String input = "-12,-4";
        try {
            calculator.add(input);
            fail("Should trow IllegalArgumentException");
        } catch (Exception e) {
            assertThat(e.getClass(), equalTo(IllegalArgumentException.class));
            assertThat(e.getMessage(), equalTo("Illegal negative number"));
        }
    }

    @Test
    public void givenSingleNumberGreaterThen1000ShouldIgnore() {
        String input = "1001,3\n4";
        int expectedResult = 3 + 4;
        int result = calculator.add(input);
        assertEquals(expectedResult,result);
    }

    @Test
    public void multipleNumberGreaterThanOneThousandThenIgnore() {
        String input = "1002,10\n10000,5";
        int excpected = 10 + 5;
        assertThat(calculator.add(input), equalTo(excpected));
    }

    @Test
    public void givenMaxNumberThenReturnSum() {
        String input = "1000,2\n5";
        int expected = 1000 + 2 + 5;
        assertThat(calculator.add(input), equalTo(expected));
    }

    @Test
    public void givenSingleCharAsADelimiterThenReturnSUm() {
        String input = "//#12#4\n4";
        int expected = 12 + 4 + 4;
        assertThat(calculator.add(input), equalTo(expected));
    }

}