package com.example.checkbookservice.consumer;

import com.example.checkbookservice.model.Book;
import com.example.checkbookservice.service.CheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookConsumer {
	private final KafkaTemplate<String, Book> kafkaTemplate;
	private final CheckService service;

	@Value("${spring.kafka.producer.topic}")
	private String producerTopic;

	@KafkaListener(
			topics = "#{'${spring.kafka.consumer.topic}'}",
			groupId = "check-book",
			containerFactory = "exampleKafkaListenerContainerFactory"
	)
	public void process(Book book) {
		kafkaTemplate.send(producerTopic, service.checkBook(book));
		System.out.println(book);
	}
}
