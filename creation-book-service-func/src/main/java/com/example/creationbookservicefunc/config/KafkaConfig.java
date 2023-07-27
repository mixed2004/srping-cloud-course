package com.example.creationbookservicefunc.config;

import com.example.creationbookservicefunc.model.Book;
import net.datafaker.Faker;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@Configuration
@EnableScheduling
public class KafkaConfig {

	@Bean
	public Faker faker() {
		return new Faker();
	}

	@Bean
	public Supplier<Book> bookProducer() {
		return this::createBook;
	}

//	@Bean
//	public Consumer<Book> consumer() {
//		return message -> System.out.println("received " + message);
//	}


//	public Map<String, Object> producerConfig() {
//		HashMap<String, Object> properties = new HashMap<>();
//		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//		return properties;
//	}

	private Book createBook() {
		return Book.builder()
				.id(faker().number().randomNumber())
				.name(faker().book().title())
				.description(faker().book().author())
				.status("unchecked")
				.price(faker().number().randomDouble(2, 2,15))
				.build();
	}

}
