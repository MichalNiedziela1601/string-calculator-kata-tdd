package com.example.string_calculator_kata;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
        private final Pattern patternSingleCustomDelimiter = Pattern.compile("^(//(.)\n).*$");


    public List<Integer> parseInput(String input) {
        String separators = "[,\n]";
        String tempInput = input;
        Matcher matcher = patternSingleCustomDelimiter.matcher(input);
        if(matcher.matches()) {
            separators = matcher.group(2);
            System.out.println(matcher.group(1).length());
            tempInput = tempInput.substring(matcher.group(1).length());
        }
        String[] numbers = tempInput.split(separators);
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
