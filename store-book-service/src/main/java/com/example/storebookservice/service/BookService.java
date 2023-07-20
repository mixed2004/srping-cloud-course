package com.example.storebookservice.service;

import com.example.storebookservice.model.Book;
import com.example.storebookservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
	private  final BookRepository repository;

	public Book saveBook(Book book) {
		return repository.save(book);
	}
}
