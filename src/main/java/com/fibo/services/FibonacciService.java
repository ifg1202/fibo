package com.fibo.services;

public class FibonacciService {

	public Integer getValue(Integer element) {
		return element.equals(Integer.valueOf(0)) ? 0 : 1 ;
	}

}
