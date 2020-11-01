package com.fibo.interfaces.rest;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fibo.application.queryservices.FibonacciQueryService;
import com.fibo.domain.valueobjects.FibonacciValue;

@RestController
@RequestMapping("/v1/fibonacci")
public class FibonacciController {

	FibonacciQueryService fibonacciQueryService;
	
	public FibonacciController(FibonacciQueryService fibonacciService) {
		this.fibonacciQueryService = fibonacciService;
	}

	@GetMapping(path = "/{element}", produces = "application/json")
	public ResponseEntity<FibonacciValue> getFibonacciValue(
			@PathVariable Integer element) {
		Optional<BigDecimal> value = fibonacciQueryService.getValue(element);
		return value.isPresent() ? 
				new ResponseEntity<>(new FibonacciValue(value.get()), HttpStatus.OK) :
				new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
}
