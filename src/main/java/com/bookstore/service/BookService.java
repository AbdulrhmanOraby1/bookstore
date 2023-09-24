package com.bookstore.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bookstore.model.Book;

@Service
public interface BookService {
    List<Book>getAllBooks();
    void save(Book bok);
    Book getBookById(Long id);
}
