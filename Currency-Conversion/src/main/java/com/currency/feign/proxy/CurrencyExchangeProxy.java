package com.currency.feign.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.currency.conversion.dto.CurrencyConversionDTO;

//@FeignClient(name="currency-exchange", url="http://localhost:8000")
@FeignClient(name="currency-exchange")
@RibbonClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
	/*
	 * java.lang.ClassNotFoundException: com.netflix.config.CachedDynamicIntProperty
	 */
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionDTO getCurrencyConversion
	(@PathVariable("from") String from, @PathVariable("to") String to);

}
