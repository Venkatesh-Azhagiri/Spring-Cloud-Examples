package com.currency.conversion.dto;

import java.math.BigDecimal;

public class CurrencyConversionDTO {
	private Long id;
	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal conversionValue;
	private BigDecimal totalCalculatedAmt;
	private int port;
	
	public CurrencyConversionDTO(){
		
	}
	
	public CurrencyConversionDTO(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionValue,
			BigDecimal totalCalculatedAmt, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.conversionValue = conversionValue;
		this.totalCalculatedAmt = totalCalculatedAmt;
		this.port = port;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	
	
	public BigDecimal getConversionValue() {
		return conversionValue;
	}
	public void setConversionValue(BigDecimal conversionValue) {
		this.conversionValue = conversionValue;
	}
	public BigDecimal getTotalCalculatedAmt() {
		return totalCalculatedAmt;
	}
	public void setTotalCalculatedAmt(BigDecimal totalCalculatedAmt) {
		this.totalCalculatedAmt = totalCalculatedAmt;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
	

}
