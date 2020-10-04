package org.example.repository;

import java.util.List;
import java.util.Optional;

import org.example.entity.*;
import org.example.model.AuthorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
//	Book save(Book book);
//
//	List<Book> findAll();
//
//	void deleteById(Long id);
//
//	Optional<Book> findById(Long id);

	@Query(value = "select * from books where authorid=:authorId", nativeQuery = true)
	List<Book> getBooksByAuthorId(@Param("authorId") Long authorId);
}