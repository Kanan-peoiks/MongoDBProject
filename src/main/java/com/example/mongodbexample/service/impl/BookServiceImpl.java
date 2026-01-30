package com.example.mongodbexample.service.impl;

import com.example.mongodbexample.dto.BookRequest;
import com.example.mongodbexample.dto.BookResponse;
import com.example.mongodbexample.model.Book;
import com.example.mongodbexample.repository.BookRepository;
import com.example.mongodbexample.service.BookService;
import com.example.mongodbexample.validation.ResourceNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookResponse createBook(BookRequest bookRequest) {
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setAuthor(bookRequest.getAuthor());
        book.setIsbn(bookRequest.getIsbn());
        book.setCategory(bookRequest.getCategory());
        book.setPageCount(bookRequest.getPageCount());

        Book db = bookRepository.save(book);
        return mapToResponse(db);
    }


    @Override
    public BookResponse findById(String id) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
        new ResourceNotFoundException("Book not found with id: " + id));
    return mapToResponse(book);
    }

    @Override
    public List<BookResponse> findByAll() {
       return bookRepository
               .findAll(Sort.by(Sort.Direction.DESC, "publishDate"))
               .stream()
               .map(this :: mapToResponse)
               .collect(Collectors.toList());
    }

    @Override
    public BookResponse updateBook(String id, BookRequest bookRequest) {
        Book existing = bookRepository.findById(id).orElseThrow(() ->
        new ResourceNotFoundException("Book not found with id: " + id));

        existing .setTitle(bookRequest.getTitle());
        existing.setAuthor(bookRequest.getAuthor());
        existing.setIsbn(bookRequest.getIsbn());
        existing.setCategory(bookRequest.getCategory());
        existing.setPageCount(bookRequest.getPageCount());

        Book updated = bookRepository.save(existing);

        return mapToResponse(updated);
    }

    @Override
    public void deleteById(String id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Book not found with id: " + id)
                );
    bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findByCategory(String category) {
        return bookRepository.findByCategory(category);
    }


    private BookResponse mapToResponse(Book book) {
        BookResponse response = new BookResponse();
        response.setId(book.getId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setIsbn(book.getIsbn());
        response.setCategory(book.getCategory());
        response.setPageCount(book.getPageCount());
        response.setPublishDate(book.getPublishDate());
        return response;
    }

}
