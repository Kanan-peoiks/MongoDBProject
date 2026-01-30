package com.example.mongodbexample.repository;

import com.example.mongodbexample.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,String> {
    List<Book> findByCategory(String category);

}
