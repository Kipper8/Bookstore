package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.model.Book;

@Controller
@ResponseBody

public class BookController {
	Book book = new Book();
	@RequestMapping(method= RequestMethod.GET, value= "/index")
	public String hello() {
		return book.toString();
	}
}