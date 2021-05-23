package com.kushal.microservices.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limit-microservices")
public class Configuration {
	
	private int minimum;
	private int maximum;
		
	public int getMinimun() {
		return minimum;
	}
	public void setMinimun(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	

}
