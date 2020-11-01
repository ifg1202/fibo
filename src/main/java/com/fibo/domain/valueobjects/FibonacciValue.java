package com.fibo.domain.valueobjects;

import java.math.BigDecimal;

public class FibonacciValue {
	
	private BigDecimal value;
	
	public FibonacciValue(BigDecimal value) {
		this.value = value;
	}

	public FibonacciValue() {
	}
	
	public BigDecimal getValue() {
		return value;
	}
	
}
