package com.example.mongodbexample.model;

import lombok.Data;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "Books")
public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String isbn;
    private String category;
    private Integer pageCount;
    private LocalDateTime publishDate;
}
