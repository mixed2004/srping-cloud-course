package com.example.creationbookservicefunc.service;

import com.example.creationbookservicefunc.model.Book;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@EnableScheduling
@Component
@RequiredArgsConstructor
public class BookSender {

	private final StreamBridge streamBridge;
	private final Faker faker;


	@Scheduled(
			fixedRate = 10,
			timeUnit = TimeUnit.SECONDS
	)
	public void bookSender() {
		streamBridge.send("bookProducer-out-0", createBook());
		System.out.println("_____________________________");
	}

	private Book createBook() {
		return Book.builder()
				.id(faker.number().randomNumber())
				.name(faker.book().title())
				.description(faker.book().author())
				.status("unchecked")
				.price(faker.number().randomDouble(2, 2, 15))
				.build();
	}
}
