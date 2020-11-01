package com.fibo.interfaces.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fibo.application.queryservices.FibonacciQueryService;

@WebMvcTest(FibonacciController.class)
public class FibonacciControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	FibonacciQueryService fibonacciQueryService;

	@Test
	void getFirstFibonacciElement() throws Exception {
		// given
		Integer element = 0;
		given(fibonacciQueryService.getValue(element)).willReturn(Optional.of(BigDecimal.ZERO));
		// when
		mockMvc.perform(get("/v1/fibonacci/" + element))
		// then
		.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.value", is(0)));
	}

	@Test
	void tryToGetInvalidElement() throws Exception {
		// given
		Integer element = -1;
		given(fibonacciQueryService.getValue(element)).willReturn(Optional.empty());
		// when
		mockMvc.perform(get("/v1/fibonacci/" + element))
		// then
		.andExpect(status().is(HttpStatus.NOT_FOUND.value()));	
	}

}

