package com.library_management.service;

import com.library_management.model.Author;
import com.library_management.model.Book;

import java.util.List;
import java.util.Optional;

public interface LibraryService {
    List<Author> getAllAuthors();

    Optional<Author> getAuthorById(Long id);

    Author saveAuthor(Author author);

    void deleteAuthor(Long id);

    List<Book> getAllBooks();

    Optional<Book> getBookById(Long id);

    Book saveBook(Book book);

    void deleteBook(Long id);
}
