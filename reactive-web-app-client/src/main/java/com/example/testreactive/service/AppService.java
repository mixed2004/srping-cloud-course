package com.example.testreactive.service;

import com.example.testreactive.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AppService {
	private final WebClient webClient;

	public Mono<Book> getBookByIdAsync(final Long id) {
		return webClient
				.get()
				.uri(String.join("", "/book/get/", id.toString()))
				.retrieve()
				.bodyToMono(Book.class);
	}

	public Flux<Book> getBooks() {
		return webClient
				.get()
				.uri("/book/all")
				.retrieve()
				.bodyToFlux(Book.class);
	}

}