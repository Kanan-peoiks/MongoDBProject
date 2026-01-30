package com.example.mongodbexample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String title;
    private String author;
    private String isbn;
    private String category;
    private Integer pageCount;
    private LocalDateTime publishDate;
}
