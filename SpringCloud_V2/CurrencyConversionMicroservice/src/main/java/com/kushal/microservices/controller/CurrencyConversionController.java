package com.kushal.microservices.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kushal.microservices.beans.CurrencyConversion;
import com.kushal.microservices.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateConvertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable String quantity) {

		CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);

		return new CurrencyConversion(currencyConversion.getId(), from, to, currencyConversion.getConversionMultiple(),
				BigDecimal.valueOf(Double.valueOf(quantity)).multiply(currencyConversion.getConversionMultiple()),
				BigDecimal.ONE, currencyConversion.getEnvironment());

	}

	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateConvertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable String quantity) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8765/CURRENCY-EXCHANGE/currency-exchange"
				+ "/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		CurrencyConversion currencyConversion = responseEntity.getBody();

		return new CurrencyConversion(currencyConversion.getId(), from, to, currencyConversion.getConversionMultiple(),
				BigDecimal.valueOf(Double.valueOf(quantity)).multiply(currencyConversion.getConversionMultiple()),
				BigDecimal.ONE, currencyConversion.getEnvironment());

	}
	
	}
