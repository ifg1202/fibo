package com.fibo.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class FibonacciService {

	public Optional<BigDecimal> getValue(Integer element) {
		return isValidElement(element) ? getFibonacciValue(element) : Optional.empty();
	}

	private Optional<BigDecimal> getFibonacciValue(Integer element) {
		return isFirstElement(element) ? Optional.of(BigDecimal.ZERO) : performFibonacci(element);
	}

	private Optional<BigDecimal> performFibonacci(Integer element) {
		BigDecimal value = BigDecimal.ONE;
		BigDecimal first = BigDecimal.ZERO;
		BigDecimal second = BigDecimal.ONE;
		for(int counter = 1; counter < element; counter++) {
			value =  second.add(first);
			first = second;
			second = value;
		}
		return Optional.of(value);
	}

	private boolean isValidElement(Integer element) {
		return element >= 0;
	}
	
	private boolean isFirstElement(Integer element) {
		return element == 0;
	}

}
