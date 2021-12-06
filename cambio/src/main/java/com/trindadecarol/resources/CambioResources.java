package com.trindadecarol.resources;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trindadecarol.entities.Cambio;
import com.trindadecarol.repository.CambioRepository;

@RestController
@RequestMapping("/cambio")
public class CambioResources {
	
	@Autowired
	Environment environment;
	
	@Autowired
	CambioRepository cambioRepository;
	
	@GetMapping("/{amount}/{from}/{to}")
	public Cambio getCambio(@PathVariable("amount") BigDecimal amount,
							@PathVariable("from") String from,
							@PathVariable("to") String to) {
		
		Cambio cambio = cambioRepository.findByfromAndTo(from, to);
		if(cambio == null) throw new RuntimeException("Currency onsupported");
		
		String port = environment.getProperty("local.server.port");
		cambio.setConvertedValue(cambio.getConversionFactor().multiply(amount).setScale(2, RoundingMode.CEILING));
		cambio.setEnviroment(port);
		
		return cambio;
	}
	

}
