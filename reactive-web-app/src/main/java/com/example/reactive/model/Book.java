package com.example.reactive.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document(collection = "books")
public class Book {
	@Id
	private Long id;
	private String name;
	private String description;
	private String status;
	private double price;
}
