package com.fibo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fibo.model.FibonacciResult;

@RestController
@RequestMapping("/v1/fibonacci")
public class FibonacciController {


	@GetMapping(path = "/{element}", produces = "application/json")
	public ResponseEntity<FibonacciResult> getFibonacciValue(
			@PathVariable Integer element) {
		return new ResponseEntity<>(new FibonacciResult(0), HttpStatus.OK);
	}
}
