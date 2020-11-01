package com.fibo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FibonacciServiceTest {

	FibonacciService fibonacciService = new FibonacciService();
	
	@Test
	void getFirstValue() {
		//given
		Integer firtsElement = 0;
		//when
		Optional<BigDecimal> value = fibonacciService.getValue(firtsElement);
		//then
		assertEquals(BigDecimal.ZERO, value.get());
	}
	
	@Test
	void getSecondValue() {
		//given
		Integer secondElement = 1;
		//when
		Optional<BigDecimal> value = fibonacciService.getValue(secondElement);
		//then
		assertEquals(BigDecimal.ONE, value.get());
	}
	
	@ParameterizedTest
	@CsvSource({
	    "2, 1",
	    "3, 2",
	    "4, 3",
	    "5, 5",
	    "6, 8",
	    "7, 13",
	    "8, 21",
	    "50, 12586269025"
	})
    void performFibonacciSecuence(Integer element, BigDecimal value) {
		//then
		assertEquals(value, fibonacciService.getValue(element).get());
    }
	
	@Test
	void getInvalidElement() {
		//given
		Integer invalidElement = -1;
		//when
		Optional<BigDecimal> value = fibonacciService.getValue(invalidElement);
		//then
		assertTrue(value.isEmpty());
	}
	
}
