package com.example.controller;

import com.example.bookservice.BookService;
import com.example.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;

	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {
		return new ResponseEntity(bookService.getAllBooks(), HttpStatus.OK);
	}
}
