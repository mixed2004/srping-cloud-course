package com.example.reactive.init;

import com.example.reactive.model.Book;
import com.example.reactive.service.BookService;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Init {

	private final BookService service;
	private final Faker faker;

	@PostConstruct
	public void init() {
		List<Book> books  = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			books.add(createBook());
		}
		var savedBooks = service.add(books);
		savedBooks
				.doOnNext(System.out::println)
				.subscribe();
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
