package com.kushal.microservices.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kushal.microservices.beans.CurrencyConversion;

//@FeignClient(name="currency-exchange", url="localhost:8000") // here we need to application name
//@Feign(name="currency-exchange") // For Load Balancing in Action
@FeignClient(name="api-gateway")
public interface CurrencyExchangeProxy {

	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/CURRENCY-EXCHANGE/currency-exchange/from/{from}/to/{to}") // This is to route the request through API gateway
	public CurrencyConversion retrieveExchangeValue
	(@PathVariable String from, @PathVariable String to);
	
}
