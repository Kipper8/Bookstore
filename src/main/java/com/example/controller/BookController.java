package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Book;
import com.example.model.BookRepository;


@Controller

public class BookController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping("/login")
	public String login() {
    	return "login";
    }
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String booklist(Model model) {
		List<Book> booklist = (List<Book>) repository.findAll();
		model.addAttribute("books", booklist);
    	return "booklist";
    }
	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id, Model model) {
    	repository.delete(id);
        return "redirect:/booklist";
    }
	@RequestMapping(value = "/addBook")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        return "addBook";
    }
	@RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
    	return "redirect:/booklist";
    }
}