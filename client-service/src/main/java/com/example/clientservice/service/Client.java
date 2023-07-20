package com.example.clientservice.service;

import com.example.clientservice.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "book-service", url = "http://localhost:8086")
public interface Client {

    @GetMapping("/api/books")
    List<Book> getAllBooks();

}
