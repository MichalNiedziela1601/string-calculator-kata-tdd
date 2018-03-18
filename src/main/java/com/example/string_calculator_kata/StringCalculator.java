package com.example.string_calculator_kata;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String input) {
        if(input.isEmpty()) return 0;
        List<Integer> parsedNumbers = parseInput(input);

        return sumOf(parsedNumbers);
    }

    private List<Integer> parseInput(String input) {
        String separators = "[,\n]";
        String[] numbers = input.split(separators);
        for(String val : numbers) {
            if(0 > Integer.valueOf(val)) throw new IllegalArgumentException("Illegal negative number");
        }
        List<Integer> outputNumbers = new ArrayList<>();
        for(String number : numbers) {
            outputNumbers.add(Integer.valueOf(number));
        }
        return outputNumbers;
    }

    private int sumOf(List<Integer> numbers) {
        int sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
