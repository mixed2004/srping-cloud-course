package com.example.storebookservice.config;

import com.example.storebookservice.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class KafkaConfig {

	@Bean
	public Consumer<Book> bookProcessor() {
		return System.out::println;
	}

}
