package com.currency.exchange.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class CurrencyExchangeController {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchangeBean getCurrencyExchange(
			@PathVariable String from, @PathVariable String to){
		return new CurrencyExchangeBean(from, to, new BigDecimal(70.83));
	}

}
