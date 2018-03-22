package com.example.string_calculator_kata.web;


import com.example.string_calculator_kata.CalculatorCommand;
import com.example.string_calculator_kata.StringCalculator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorRest {

    private StringCalculator calculator;

    public CalculatorRest(StringCalculator calculator) {
        this.calculator = calculator;
    }

    @RequestMapping(value = "/api/calculator", method = RequestMethod.POST)
    public ResponseEntity<Integer> add(@RequestBody CalculatorCommand command) {
        int  value = calculator.add(command);
        return new ResponseEntity<Integer>(value, HttpStatus.OK);
    }
}
