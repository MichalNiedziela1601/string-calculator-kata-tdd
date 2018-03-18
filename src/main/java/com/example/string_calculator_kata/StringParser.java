package com.example.string_calculator_kata;

import java.util.ArrayList;
import java.util.List;

public class StringParser {

    public List<Integer> parseInput(String input) {
        String separators = "[,\n]";
        String[] numbers = input.split(separators);
        checkNegative(numbers);
        List<Integer> outputNumbers = new ArrayList<>();
        for(String number : numbers) {
            outputNumbers.add(Integer.valueOf(number));
        }
        return outputNumbers;
    }

    private void checkNegative(String[] numbers) {
        for(String val : numbers) {
            if(0 > Integer.valueOf(val)) throw new IllegalArgumentException("Illegal negative number");
        }
    }


}
