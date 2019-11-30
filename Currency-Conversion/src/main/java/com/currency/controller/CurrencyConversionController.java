package com.currency.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currency.conversion.dto.CurrencyConversionDTO;
import com.currency.feign.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	

	//Normal REST Call
	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionDTO getCurrencyConversion(
			@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity){
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionDTO> responseEntity =
				new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", 
						CurrencyConversionDTO.class,
						uriVariables);
		CurrencyConversionDTO response = responseEntity.getBody();
		return new CurrencyConversionDTO(response.getId(), from, to, quantity,
				response.getConversionValue(), 
				quantity.multiply(response.getConversionValue()) ,
				response.getPort());			
	}
	
	//Zuul
	//http://localhost:8765/conversion-service/currency-conversion-feign/from/usd/to/inr/quantity/2
	//http://localhost:8100/currency-conversion-feign/from/usd/to/inr/quantity/2
	//Feign call
	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionDTO getCurrencyFeignConversion(
			@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity){		
		CurrencyConversionDTO response = currencyExchangeProxy.getCurrencyConversion(from, to);
		return new CurrencyConversionDTO(response.getId(), from, to, quantity,
				response.getConversionValue(), 
				quantity.multiply(response.getConversionValue()) ,
				response.getPort());			
		
	}
	
			 
}
