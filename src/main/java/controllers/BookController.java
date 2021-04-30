package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entities.Book;
import repository.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@RequestMapping(path="/")
	public @ResponseBody String index() {
		return "index";
	}
	
	@PostMapping (path="/add")
	public @ResponseBody Book addNewBook(@RequestParam String name) {
		Book book = new Book(name);
		bookRepository.save(book);
		return book;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Book> getAllBooks(){
		return bookRepository.findAll();
	}

}
