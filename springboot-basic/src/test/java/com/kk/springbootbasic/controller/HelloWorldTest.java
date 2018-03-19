package com.kk.springbootbasic.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
public class HelloWorldTest {

   private MockMvc mockMvc;
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorld()).build();
    }

    @After
    public void tearDown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/hello?小明").accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
    }

    @Test
    public void sayHello() throws Exception {

    }

}