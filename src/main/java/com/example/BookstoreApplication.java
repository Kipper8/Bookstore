package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.Book;
import com.example.model.BookRepository;
import com.example.model.User;
import com.example.model.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository, UserRepository urepository) {
		return (args) -> {
				repository.save(new Book("Ernest Hemingway", "A Farewell to Arms", "1232323-21", "1929"));
				repository.save(new Book("George Orwell", "Animal Farm", "22122343-5", "1945"));
				
				User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
				User user2 = new User("admin", "$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2", "ADMIN");
				urepository.save(user1);
				urepository.save(user2);
		};
	}
}
