package com.kushal.microservices.beans;

import java.math.BigDecimal;

public class CurrencyExchange {

	private long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private String environment;

	public CurrencyExchange() {
		super();

	}

	public CurrencyExchange(long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.setId(id);
		this.setFrom(from);
		this.setTo(to);
		this.setConversionMultiple(conversionMultiple);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

}
