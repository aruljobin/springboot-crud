package org.example.repository;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.model.AuthorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
//    Author save(Book book);
//
//    List<Author> findAll();
//
//    void deleteById(Long id);
//
//    Optional<Author> findById(Long id);

    @Query(value = "select a.authorid, firstname, lastname, COUNT(b.authorid) as bookCount from authors as a LEFT JOIN books as b ON a.authorid=b.authorid GROUP BY a.authorid", nativeQuery = true)
    List<AuthorProjection> findAllAuthor();

}