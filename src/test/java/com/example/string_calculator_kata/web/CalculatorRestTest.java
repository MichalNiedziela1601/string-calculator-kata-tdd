package com.example.string_calculator_kata.web;

import com.example.string_calculator_kata.CalculatorCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorRestTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void addSingleNumber() throws Exception {
        CalculatorCommand command = new CalculatorCommand();
        command.setNumbers("123");
        String json = mapper.writeValueAsString(command);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/calculator")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(content().string("123"));
    }

    @Test
    public void addMultiNumbers() throws Exception {
        CalculatorCommand command = new CalculatorCommand();
        command.setNumbers("123,45");
        String result = String.valueOf(123 + 45);
        String json = mapper.writeValueAsString(command);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/calculator")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(content().string(result));
    }

    @Test
    public void addMultiNumbersWithDelimiter() throws Exception {
        CalculatorCommand command = new CalculatorCommand();
        command.setNumbers("//#\n123#45");
        String result = String.valueOf(123 + 45);
        String json = mapper.writeValueAsString(command);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/calculator")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(content().string(result));
    }




}