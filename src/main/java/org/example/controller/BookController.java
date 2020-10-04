package org.example.controller;


import java.util.List;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.dto.NewBookDto;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;
import org.example.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.example.config.*;;

@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookRepository bookRepository;
	@Autowired
	DataService dataService;

	@Autowired
	AuthorRepository authorRepository;

	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getAll() {
		return bookRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public List<Book> getBooksByAuthor(@PathVariable Long id) {
		return dataService.getBooksByAuthor(id);
	}
	
	@PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public Book saveBook(@RequestBody NewBookDto newBookDto) {
		Book newBook = new Book();

		Author author = authorRepository.findById(newBookDto.getAuthorId())
				.orElseThrow(() -> new UserNotFoundException(newBookDto.getAuthorId()));

		newBook.setAuthorId(author);
		newBook.setBookname(newBookDto.getBookname());
		newBook.setBookprice(newBookDto.getBookPrice());
		newBook.setCreatedate(newBookDto.getCreateDate());
		newBook.setPublishdate(newBookDto.getPublishDate());
		return bookRepository.save(newBook);
	}

	@PutMapping("/{id}")
	Book replaceBook(@RequestBody NewBookDto newBookDto, @PathVariable Long id) {

		Book book = bookRepository.findById(id)
				.orElseThrow(()-> new UserNotFoundException(id));

		Author author = authorRepository.findById(newBookDto.getAuthorId())
				.orElseThrow(() -> new UserNotFoundException(newBookDto.getAuthorId()));

		book.setAuthorId(author);
		book.setBookname(newBookDto.getBookname());
		book.setBookprice(newBookDto.getBookPrice());
		book.setCreatedate(newBookDto.getCreateDate());
		book.setPublishdate(newBookDto.getPublishDate());
		return bookRepository.save(book);
	
	}

	@DeleteMapping("/{id}")
	void deleteBook(@PathVariable Long id) {
		bookRepository.deleteById(id);
	}
 
	
 
}