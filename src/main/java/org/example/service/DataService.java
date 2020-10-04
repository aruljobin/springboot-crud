package org.example.service;

import java.util.ArrayList;
import java.util.List;

import org.example.dto.AuthorResponseDto;
import org.example.entity.Book;
import org.example.model.AuthorProjection;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BookRepository bookRepository;

	public List<AuthorResponseDto> findAll() {

		List<AuthorProjection> authorProjections= authorRepository.findAllAuthor();

		List<AuthorResponseDto> authorList = new ArrayList<>();
		for(AuthorProjection authorProjection: authorProjections) {
			AuthorResponseDto dto = new AuthorResponseDto();
			dto.setId(authorProjection.getAuthorid());
			dto.setFirstname(authorProjection.getFirstname());
			dto.setLastname(authorProjection.getLastname());
			dto.setBooksCount(authorProjection.getBookCount());

			authorList.add(dto);
		}

		return authorList;
	}

	public List<Book> getBooksByAuthor(Long authorId) {

		return bookRepository.getBooksByAuthorId(authorId);
	}
}
