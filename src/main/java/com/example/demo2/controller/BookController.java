package com.example.demo2.controller;

import java.util.List;
import java.util.Map;

import com.example.demo2.model.Book;
import com.example.demo2.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * BookController
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:8080")
public class BookController {
  @Autowired
  private BookRepository bookRepository;

  @GetMapping("/books")
  @ResponseBody
  public List<Book> getAllBooks(@RequestParam(required = false) Map<String, String> value) {
    if(value.isEmpty()) {
      return bookRepository.findAll();
    }

    String title = value.get("title");
    String year_of_release = value.get("year_of_release");
    String genre = value.get("genre");
    String author = value.get("author");
    return bookRepository.searchBy(title, year_of_release, author, genre);
  }
}