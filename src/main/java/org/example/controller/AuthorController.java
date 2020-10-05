package org.example.controller;


import java.util.List;

import org.example.entity.Author;
import org.example.dto.AuthorResponseDto;
import org.example.repository.AuthorRepository;
import org.example.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.example.config.*;;

@CrossOrigin
@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    DataService dataService;

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AuthorResponseDto>  getAll() {
        return dataService.findAll();
    }

    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public Author saveAuthor(@RequestBody Author newAuthor) {
        return authorRepository.save(newAuthor);
    }

    @PutMapping("/{id}")
    Author replaceAuthor(@RequestBody Author newAuthor, @PathVariable Long id) {

        Author book = authorRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        book.setFirstname(newAuthor.getFirstname());
        book.setLastname(newAuthor.getLastname());
        return authorRepository.save(book);

    }

    @DeleteMapping("/{id}")
    Long deleteAuthor(@PathVariable Long id) {
        authorRepository.deleteById(id);
        return id;
    }

}