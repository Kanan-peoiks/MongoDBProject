package com.example.mongodbexample.controller;

import com.example.mongodbexample.repo.BookRepo;
import com.example.mongodbexample.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller("/api/books")
public class BookController {
    private final BookService  bookService;
    private final ResourceUrl

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


}
