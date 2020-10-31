package com.fibo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.fibo.model.FibonacciResult;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FiboApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	void contextLoads() {
		//given
		Integer element = 100;
		//when
		FibonacciResult result = restTemplate.getForObject("/v1/fibonacci/" + element, FibonacciResult.class);
		//then
		assertEquals(new BigDecimal("354224848179261915075"), result.getValue());
	}

}
