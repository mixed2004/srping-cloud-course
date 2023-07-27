package com.example.reactive.controller;


import com.example.reactive.model.Book;
import com.example.reactive.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

	private final BookService service;

	@GetMapping("/all")
	public Flux<Book> getAllInvoices() {
		return service.getAll();
	}

	@GetMapping("/get/{id}")
	public Mono<Book> getOneInvoice(@PathVariable Long id) {
		return service.getById(id);
	}

}