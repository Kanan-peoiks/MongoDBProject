package com.example.mongodbexample.service;

import com.example.mongodbexample.model.Book;
import com.example.mongodbexample.repo.BookRepo;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book createBook(Book book) {
        return bookRepo.save(book);
    }
}
