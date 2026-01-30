package com.example.mongodbexample.service;


import com.example.mongodbexample.dto.BookRequest;
import com.example.mongodbexample.dto.BookResponse;
import com.example.mongodbexample.model.Book;

import java.util.List;

public interface BookService {

    BookResponse createBook(BookRequest bookRequest);
    BookResponse findById(String id);

    List<BookResponse> findByAll();

    BookResponse updateBook(String id, BookRequest bookResponse);

    void deleteById(String id);

    List<Book> findByCategory(String category);
}
