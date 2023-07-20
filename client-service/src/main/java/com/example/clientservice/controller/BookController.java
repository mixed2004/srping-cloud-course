package com.example.clientservice.controller;

import com.example.clientservice.model.Book;
import com.example.clientservice.service.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class BookController {

	private final Client feignClient;

	@GetMapping("/books")
	public List<Book> getAllBooksFromClient() {
		return feignClient.getAllBooks();
	}
}
