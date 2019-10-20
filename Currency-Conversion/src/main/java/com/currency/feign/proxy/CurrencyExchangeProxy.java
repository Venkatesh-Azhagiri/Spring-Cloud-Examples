package com.currency.feign.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.currency.conversion.dto.CurrencyConversionDTO;

@FeignClient(name="currency-exchange", url="http://localhost:8000")
public interface CurrencyExchangeProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionDTO getCurrencyConversion
	(@PathVariable("from") String from, @PathVariable("to") String to);

}
