package com.example.string_calculator_kata;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static int MAX_NUMBER = 1000;

    public int add(String input) {
        if(input.isEmpty()) return 0;
        List<Integer> parsedNumbers = new StringParser().parseInput(input);
        List<Integer> remainsNumbers = checkNumberOutOfBound(parsedNumbers);
        return sumOf(remainsNumbers);
    }


    private int sumOf(List<Integer> numbers) {
        int sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private List<Integer> checkNumberOutOfBound(List<Integer> numbers) {
        List<Integer> outOfBoundNumbers = new ArrayList<>();
        for(int val : numbers) {
            if(val <= MAX_NUMBER) {
                outOfBoundNumbers.add(val);
            }
        }
        return outOfBoundNumbers;
    }
}
