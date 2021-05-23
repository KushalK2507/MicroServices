package com.kushal.microservices.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kushal.microservices.beans.CurrencyExchange;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	private static Logger LOG =LoggerFactory.getLogger(CurrencyExchange.class);

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue
	(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchange = 
				new CurrencyExchange
				(1000L, from, to, BigDecimal.valueOf(50));
	currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
	
	LOG.info(currencyExchange.toString());
		return currencyExchange;
	}
}
