package com.trindadecarol.resources;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trindadecarol.client.CambioClient;
import com.trindadecarol.entities.Book;
import com.trindadecarol.repository.BookRepository;
import com.trindadecarol.response.CambioResponse;

@RestController
@RequestMapping("/book-service")
public class BookResource {
	
	@Autowired
	Environment environment;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CambioClient cambioClient;

	@GetMapping("/{id}/{currency}")
	public Book findBook(@PathVariable ("id") Long id,
			             @PathVariable ("currency") String currency) {
		
		Book book = bookRepository.getById(id);
		if(book == null) throw new RuntimeException("Book unavaliable");
		String port = environment.getProperty("local.server.port");
		CambioResponse cambio = cambioClient.getCambio(book.getPrice(), "USD", currency);
		book.setPrice(cambio.getConvertedValue());
		book.setEnvironment(port);
		
		return book;
	}
}
