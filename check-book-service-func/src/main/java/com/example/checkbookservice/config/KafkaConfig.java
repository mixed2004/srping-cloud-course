package com.example.checkbookservice.config;

import com.example.checkbookservice.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class KafkaConfig {

	@Bean
	public Function<Book, Book> bookProcessor() {
		return message -> {
			System.out.println(message);
			message.setStatus("checked");
			return message;
		};
	}

}
