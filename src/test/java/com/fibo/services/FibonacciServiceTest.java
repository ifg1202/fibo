package com.fibo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FibonacciServiceTest {

	FibonacciService flightService = new FibonacciService();
	
	@Test
	void getFirstValue() {
		//given
		Integer firtsElement = 0;
		//when
		Integer value = flightService.getValue(firtsElement);
		//then
		assertEquals(0, value);
	}
	
	@Test
	void getSecondValue() {
		//given
		Integer secondElement = 1;
		//when
		Integer value = flightService.getValue(secondElement);
		//then
		assertEquals(1, value);
	}
	
	
}
