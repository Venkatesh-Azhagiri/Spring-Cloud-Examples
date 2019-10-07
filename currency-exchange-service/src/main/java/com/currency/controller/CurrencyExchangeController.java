package com.currency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currency.entity.CurrencyExchange;
import com.currency.repository.ExchangeCurrencyRepository;



@RestController	
public class CurrencyExchangeController {
	@Autowired
	private Environment environment;
	@Autowired
	private ExchangeCurrencyRepository exchangeCurrencyRepository;
	
	
	//http://localhost:8000/currency-exchange/from/usd/to/inr
	//http://localhost:8000/h2-console/
	//jdbc:h2:mem:testdb
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange getCurrencyExchange(
			@PathVariable String from, @PathVariable String to){
		CurrencyExchange currencyExchangeBean =
				exchangeCurrencyRepository.findByFromAndTo(from.toUpperCase(), to.toUpperCase());
		currencyExchangeBean.setPort(Integer.parseInt(environment.getProperty("server.port")));
		//return new CurrencyExchange();
		return currencyExchangeBean;
	}

}
