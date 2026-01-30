package com.example.mongodbexample.repository;

import com.example.mongodbexample.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,String> {
}
