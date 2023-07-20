package com.example.checkbookservice.config;

import com.example.checkbookservice.model.Book;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;

	@Bean
	public ConsumerFactory<String, Book> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(
				consumerConfig(),
				new StringDeserializer(),
				new JsonDeserializer<>(Book.class, false)
		);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Book>
	exampleKafkaListenerContainerFactory() {

		ConcurrentKafkaListenerContainerFactory<String, Book> factory =
				new ConcurrentKafkaListenerContainerFactory<>();

		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	@Bean
	public ProducerFactory<String, Book> producerFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfig());
	}

	@Bean
	public KafkaTemplate<String, Book> kafkaTemplate(
			ProducerFactory<String, Book> producerFactory
	) {
		return new KafkaTemplate<>(producerFactory);
	}

	public Map<String, Object> producerConfig() {
		HashMap<String, Object> prop = new HashMap<>();
		prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return prop;
	}

	public Map<String, Object> consumerConfig() {
		HashMap<String, Object> prop = new HashMap<>();
		prop.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		prop.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		prop.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		prop.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		prop.put(ConsumerConfig.ISOLATION_LEVEL_CONFIG, "read_committed");
		prop.put(JsonDeserializer.VALUE_DEFAULT_TYPE, Book.class);
		prop.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		return prop;
	}

}
