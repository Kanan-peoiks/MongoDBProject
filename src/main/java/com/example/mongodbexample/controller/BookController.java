package com.example.mongodbexample.controller;

import com.example.mongodbexample.dto.BookRequest;
import com.example.mongodbexample.dto.BookResponse;
import com.example.mongodbexample.model.Book;
import com.example.mongodbexample.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@RequestBody Book book) {
        BookResponse bookResponse = new BookResponse();
        return ResponseEntity.status(HttpStatus.CREATED).body(bookResponse);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        List<BookResponse> bookResponseList = bookService.findByAll();
        return ResponseEntity.ok(bookResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable String id) {
        BookResponse bookResponse = bookService.findById(id);
        return ResponseEntity.ok(bookResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable String id, @Valid @RequestBody BookRequest request) {
        BookResponse response = bookService.updateBook(id, request);
        return ResponseEntity.ok(response); // 200 OK
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Book>> getBooksByCategory(@PathVariable String categoryName) {
        List<Book> books = bookService.findByCategory(categoryName);
        return ResponseEntity.ok(books); // 200 OK
    }

}

