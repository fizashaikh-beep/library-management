package com.library.controller;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepo;

    // GET all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    // GET one book by ID
    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    // POST add a new book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookRepo.save(book);
    }

    // PUT update a book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updated) {
        updated.setAvailable(updated.isAvailable());
        return bookRepo.save(updated);
    }

    // DELETE a book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepo.deleteById(id);
        return "Book deleted";
    }
}