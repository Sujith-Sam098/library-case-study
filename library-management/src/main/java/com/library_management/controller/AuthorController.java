package com.library_management.controller;

import com.library_management.model.Author;
import com.library_management.service.LibraryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final LibraryServiceImpl libraryService;

    public AuthorController(LibraryServiceImpl libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping //
    public List<Author> getAllAuthors() {
        return libraryService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.of(libraryService.getAuthorById(id));
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return libraryService.saveAuthor(author);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        Optional<Author> author1=libraryService.getAuthorById(id);
        if(author1.isPresent())
        {
            return ResponseEntity.ok(libraryService.saveAuthor(author));

        }
        else return ResponseEntity.ofNullable(author);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
       libraryService.deleteAuthor(id);
       return null;
    }
}
