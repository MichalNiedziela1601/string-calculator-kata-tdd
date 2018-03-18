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

}