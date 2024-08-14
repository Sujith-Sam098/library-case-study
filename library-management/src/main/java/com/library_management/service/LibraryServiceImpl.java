package com.library_management.service;

import com.library_management.model.Author;
import com.library_management.model.Book;
import com.library_management.repository.AuthorRepository;
import com.library_management.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public LibraryServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        Optional<Author>authorOptional=authorRepository.findById(id);
        return authorOptional;
    }

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        System.out.println("Author with id"+id+"deleted");
        authorRepository.deleteById(id);

    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        Optional<Book> bookOptional=bookRepository.findById(id);
        return bookOptional;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        System.out.println("Book with id"+id+"deleted");
        bookRepository.deleteById(id);
    }
}
