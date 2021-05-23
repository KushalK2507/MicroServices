package com.kushal.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kushal.microservices.beans.Limits;
import com.kushal.microservices.config.Configuration;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public Limits retrieveLimits()
	{
		return new Limits (configuration.getMinimun(), configuration.getMaximum());
	}
}
