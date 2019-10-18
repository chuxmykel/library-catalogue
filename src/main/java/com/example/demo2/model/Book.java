package com.example.demo2.model;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Book
 */
@Entity
@Table(name = "books")
@EntityListeners(AuditingEntityListener.class)
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "author", nullable = false)
  private String author;

  @Column(name = "year_of_release", nullable = false)
  private String year_of_release;

  @Column(name = "genre", nullable = false)
  private String genre;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getYear_of_release() {
    return year_of_release;
  }

  public void getYear_of_release(String year_of_release) {
    this.year_of_release = year_of_release;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }
  
  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", year_of_release='" + year_of_release + '\'' +
            ", genre='" + genre + '\'' +
            '}';
  }
}