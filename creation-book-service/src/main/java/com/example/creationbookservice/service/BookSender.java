package com.example.creationbookservice.service;

import com.example.creationbookservice.model.Book;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@EnableScheduling
@Component
@RequiredArgsConstructor
public class BookSender {
	private final KafkaTemplate<String, Book> kafkaTemplate;
	private final Faker faker;
	@Value("${spring.kafka.producer.topic}")
	private String topic;

	@Scheduled(
			fixedRate = 10,
			timeUnit = TimeUnit.SECONDS
	)
	public void bookSender() {
		kafkaTemplate.send(topic, createBook());
		System.out.println("_____________________________");
	}

	private Book createBook() {
		return Book.builder()
				.id(faker.number().randomNumber())
				.name(faker.book().title())
				.description(faker.book().author())
				.status("unchecked")
				.price(faker.number().randomDouble(2, 2,15))
				.build();
	}
}
