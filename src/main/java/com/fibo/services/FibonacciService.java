package com.fibo.services;

import java.math.BigDecimal;
import java.util.Optional;

public class FibonacciService {

	public Optional<BigDecimal> getValue(Integer element) {
		 
		if (element > 1){
			BigDecimal value = BigDecimal.ZERO;
			BigDecimal first = BigDecimal.ZERO;
			BigDecimal second = BigDecimal.ONE;
			for(int index = 0; index < element - 1; index++) {
				value =  second.add(first);
				first = second;
				second = value;
			}
			return Optional.of(value);
	    }
	    else if (element == 1) {
	        return Optional.of(BigDecimal.ONE);
	    }
	    else if (element == 0){
	        return Optional.of(BigDecimal.ZERO);
	    }
		return Optional.empty();
	}

}
