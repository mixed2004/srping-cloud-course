package com.example.checkbookservice.service;

import com.example.checkbookservice.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckService {

	public Book checkBook(Book book) {
		book.setStatus("checked");
		return book;
	}
}
