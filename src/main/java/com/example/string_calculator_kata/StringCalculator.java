package com.example.string_calculator_kata;

public class StringCalculator {

    public int add(String input) {
        if(input.isEmpty()) return 0;
        return Integer.valueOf(input);
    }
}
