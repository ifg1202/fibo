package com.fibo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.fibo.model.Result;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FiboApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	void contextLoads() {
		//given
		Integer element = 100;
		//when
		ResponseEntity<Result> result = restTemplate.exchange(
                "/v1/fibonacci/{element}",
                HttpMethod.GET,
                null, Result.class, element);
		//then
		assertEquals(new BigDecimal("354224848179261915075"), result.getBody().getValue());
	}

}
