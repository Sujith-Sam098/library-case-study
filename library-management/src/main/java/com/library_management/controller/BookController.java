package com.library_management.controller;

import com.library_management.model.Book;
import com.library_management.service.LibraryServiceImpl;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final LibraryServiceImpl libraryService1;

    public BookController(LibraryServiceImpl libraryService1) {
        this.libraryService1 = libraryService1;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return libraryService1.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.of(libraryService1.getBookById(id));
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return libraryService1.saveBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Optional<Book> bookOptional=libraryService1.getBookById(id);
        if(bookOptional.isPresent())
        {
            return ResponseEntity.ok(libraryService1.saveBook(book));
        }
        else return new ResponseEntity<>(HttpStatusCode.valueOf(400));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        libraryService1.deleteBook(id);
        return null;
    }
}
