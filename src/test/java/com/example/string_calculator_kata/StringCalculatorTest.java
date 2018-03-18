package com.example.string_calculator_kata;

import org.junit.Before;
import org.junit.Test;

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
        String input = "12\n45,2";
        int expectedResult = 12 + 45 + 2;
        int result = calculator.add(input);
        assertEquals(expectedResult,result);
    }

}