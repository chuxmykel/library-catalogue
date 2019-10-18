package com.example.demo2.repository;

import java.util.List;

import com.example.demo2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * BookRepository
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
  Book findByTitle(String title);

  @Query("SELECT book FROM Book book " +
            "WHERE (:title='' or book.title LIKE %:title%) "
            +"OR (:year_of_release='' OR book.year_of_release LIKE %:year_of_release%) "
            +"OR (:author='' OR book.author LIKE %:author%) "
     +"OR (:genre='' OR book.genre LIKE %:genre%) ")
    List<Book> searchBy(
            @Param("title") String title,
            @Param("year_of_release") String year_of_release,
            @Param("author") String author,
            @Param("genre") String genre);
}