package com.example.testreactive.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Book {
	private Long id;
	private String name;
	private String description;
	private String status;
	private double price;
}
