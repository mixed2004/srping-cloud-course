package com.example.storebookservice.repository;

import com.example.storebookservice.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
