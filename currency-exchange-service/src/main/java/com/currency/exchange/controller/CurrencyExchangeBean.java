package com.currency.exchange.controller;

import java.math.BigDecimal;

public class CurrencyExchangeBean {
	
	private String from;
	private String to;
	private BigDecimal conversionValue;
	public CurrencyExchangeBean(String from, String to, BigDecimal conversionValue) {
		super();
		this.from = from;
		this.to = to;
		this.conversionValue = conversionValue;
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
	public BigDecimal getConversionValue() {
		return conversionValue;
	}
	public void setConversionValue(BigDecimal conversionValue) {
		this.conversionValue = conversionValue;
	}
}
