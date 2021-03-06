package com.trindadecarol.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.trindadecarol.response.CambioResponse;

@FeignClient(name = "cambio", url = "localhost:8000")
public interface CambioClient {

	@GetMapping("/cambio/{amount}/{from}/{to}")
	public CambioResponse getCambio(@PathVariable("amount") Double amount,
							@PathVariable("from") String from,
							@PathVariable("to") String to);
}
