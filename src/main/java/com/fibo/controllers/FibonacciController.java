package com.fibo.controllers;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fibo.model.Result;
import com.fibo.services.FibonacciService;

@RestController
@RequestMapping("/v1/fibonacci")
public class FibonacciController {

	FibonacciService fibonacciService;
	
	
	public FibonacciController(FibonacciService fibonacciService) {
		this.fibonacciService = fibonacciService;
	}

	@GetMapping(path = "/{element}", produces = "application/json")
	public ResponseEntity<Result> getFibonacciValue(
			@PathVariable Integer element) {
		Optional<BigDecimal> value = fibonacciService.getValue(element);
		return value.isPresent() ? 
				new ResponseEntity<>(new Result(value.get()), HttpStatus.OK) :
				new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
}
