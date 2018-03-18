package com.example.string_calculator_kata;

import java.util.List;

public class StringCalculator {

    public int add(String input) {
        if(input.isEmpty()) return 0;
        List<Integer> parsedNumbers = new StringParser().parseInput(input);
        return sumOf(parsedNumbers);
    }


    private int sumOf(List<Integer> numbers) {
        int sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
