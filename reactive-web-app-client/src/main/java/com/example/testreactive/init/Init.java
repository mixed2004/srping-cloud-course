package com.example.testreactive.init;

import com.example.testreactive.model.Book;
import com.example.testreactive.service.AppService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class Init {

	private final AppService service;

	@PostConstruct
	public void init() {
		Flux<Book> books = service.getBooks()
				.doOnNext(System.out::println);
		Book last = books.blockLast();

		if (last != null && last.getId() != null) {
			service.getBookByIdAsync(last.getId())
					.doOnSuccess(System.out::println)
					.block();
		}
	}

}
