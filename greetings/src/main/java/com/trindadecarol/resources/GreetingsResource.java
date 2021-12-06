package com.trindadecarol.resources;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trindadecarol.config.GreetingsConfig;
import com.trindadecarol.entities.Greetings;

@RestController
public class GreetingsResource {
	
	@Autowired
	GreetingsConfig config;

	private static final String template = "%s, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greetings greeting(@RequestParam(value="name",defaultValue = "") String name) {
		if(name.isEmpty()) name = config.getDefaultValue();
		return new Greetings(counter.incrementAndGet(),String.format(
				template,config.getGreeting(), name));
	}
	


}
