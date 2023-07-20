package com.example.storebookservice.consumer;

import com.example.storebookservice.model.Book;
import com.example.storebookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookConsumer {
	private final BookService service;

	@KafkaListener(
			topics = "#{'${spring.kafka.consumer.topic}'}",
			groupId = "check-book",
			containerFactory = "exampleKafkaListenerContainerFactory"
	)
	public void process(Book book) {
		var saveBook = service.saveBook(book);
		System.out.println(saveBook);
	}
}
