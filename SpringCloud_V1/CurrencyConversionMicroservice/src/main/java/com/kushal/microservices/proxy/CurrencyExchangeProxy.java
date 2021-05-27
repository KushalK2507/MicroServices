package com.kushal.microservices.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kushal.microservices.beans.CurrencyConversion;

//@FeignClient(name="currency-exchange", url="localhost:8000") // here we need to application name
//@FeignClient(name="currency-exchange")// For Load Balancing in Action
@FeignClient(name = "netflix-zuul-api-gateway-server") // By this we can re-route the calls through API gateway
@RibbonClient("currency-exchange")
public interface CurrencyExchangeProxy {

	// @GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("currency-exchange/currency-exchange/from/{from}/to/{to}") // In this we will add the application name
																			// as URI through Gateway changed
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

}
