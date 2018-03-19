package com.example.string_calculator_kata;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {
        private final Pattern patternSingleCustomDelimiter = Pattern.compile("^(//(.)\n).*$");
        private String defaultSeparator = "[,\n]";
        private String numbersString;


    public List<Integer> parseInput(String input) {
        numbersString = input;
        String separator = defaultSeparator;
        Matcher matcher = patternSingleCustomDelimiter.matcher(input);
        if(matcher.matches()) {
            separator = matcher.group(2);
            System.out.println(matcher.group(1).length());
            numbersString = numbersString.substring(matcher.group(1).length());
        }
        String[] numbers = numbersString.split(separator);
        checkNegative(numbers);
        return parseAsInteger(numbers);

    }

    private void checkNegative(String[] numbers) {
        for(String val : numbers) {
            if(0 > Integer.valueOf(val)) throw new IllegalArgumentException("Illegal negative number");
        }
    }

    private List<Integer> parseAsInteger(String[] stringsNumbers) {
        List<Integer> outputNumbers = new ArrayList<>();
        for(String number : stringsNumbers) {
            outputNumbers.add(Integer.valueOf(number));
        }
        return outputNumbers;
    }








}
