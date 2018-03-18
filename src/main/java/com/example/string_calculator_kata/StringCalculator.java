package com.example.string_calculator_kata;

public class StringCalculator {

    public int add(String input) {
        int sum = 0;
        if(input.isEmpty()) return 0;
        if(input.contains(",")) {
            String[] numbers = input.split(",");
            sum = Integer.valueOf(numbers[0]) + Integer.valueOf(numbers[1]);
        } else {
            sum = Integer.valueOf(input);
        }

        return sum;
    }
}
