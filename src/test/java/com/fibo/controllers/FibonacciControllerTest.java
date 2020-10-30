package com.fibo.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(FibonacciController.class)
public class FibonacciControllerTest {

	@Autowired
    MockMvc mockMvc;
	
	@Test
	void getFirstFibonacciElement() throws Exception {
		// given
		Integer element = 1;
		// when
		mockMvc.perform(get("/v1/fibonacci/" + element ))
		// then
		.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.value", is(0)));
	}
	
	@Test
	void getSecondFibonacciElement() throws Exception {
		// given
		Integer element = 2;
		// when
		mockMvc.perform(get("/v1/fibonacci/" + element ))
		// then
		.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.value", is(1)));
	}
	
}
