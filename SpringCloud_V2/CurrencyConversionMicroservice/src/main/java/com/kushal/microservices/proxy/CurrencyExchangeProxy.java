package com.kushal.microservices.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kushal.microservices.beans.CurrencyConversion;

//@FeignClient(name="currency-exchange", url="localhost:8000") // here we need to application name
@FeignClient(name="currency-exchange")// For Load Balancing in Action
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue
	(@PathVariable String from, @PathVariable String to);
	
}
