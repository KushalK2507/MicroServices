package com.kushal.microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private Logger LOG = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	//@Retry(name="sample-api", fallbackMethod="hardcodedResponse")
	//@CircuitBreaker(name="sample-api", fallbackMethod="hardcodedResponse")
	//@RateLimiter(name="default")
	@Bulkhead(name="default")
	public String samepleApi()
	{
		LOG.info("Sample API call received");
//		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/dummy", String.class);
//		return forEntity.getBody();
		return "Sample-Api";
	}
	
	public String hardcodedResponse(Exception ex)
	{
		return "fallback-Response";
	}

}
