package com.fibo.model;

import java.math.BigDecimal;

public final class Result {

	private BigDecimal value;
	
	public Result() {
	}

	public Result(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getValue() {
		return value;
	}
	
}
