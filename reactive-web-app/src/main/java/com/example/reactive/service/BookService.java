package com.example.reactive.service;

import com.example.reactive.model.Book;
import com.example.reactive.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class BookService {
	private final BookRepository repository;

	public Flux<Book> getAll() {
		return repository.findAll();
	}

	public Mono<Book> getById(Long id) {
		return repository.findById(id);
	}

	public Flux<Book> add(Collection<Book> books) {
		return repository.saveAll(books);
	}

}
