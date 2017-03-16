package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.Book;
import com.example.model.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
				repository.save(new Book("Ernest Hemingway", "A Farewell to Arms", "1232323-21", "1929"));
				repository.save(new Book("George Orwell", "Animal Farm", "22122343-5", "1945"));		
		};
	}
}
