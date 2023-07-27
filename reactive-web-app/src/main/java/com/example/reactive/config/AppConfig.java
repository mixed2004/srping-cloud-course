package com.example.reactive.config;

import net.datafaker.Faker;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;

@Configuration
public class AppConfig {
	@Bean
	public Faker faker() {
		return new Faker();
	}
}
