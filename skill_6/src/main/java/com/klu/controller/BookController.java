package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.Book;
import com.klu.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository repo;

    // CREATE
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return repo.save(book);
    }

    // READ ALL
    @GetMapping
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book existing = repo.findById(id).orElse(null);
        if (existing != null) {
            existing.setTitle(book.getTitle());
            existing.setAuthor(book.getAuthor());
            existing.setPrice(book.getPrice());
            return repo.save(existing);
        }
        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        repo.deleteById(id);
        return "Book Deleted Successfully";
    }
}
