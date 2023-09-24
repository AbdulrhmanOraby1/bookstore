package com.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    
    @Autowired private BookRepository bookRepository;

    @Override public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    @Override public void save(Book bok){
        bookRepository.save(bok);
    }

    @Override public Book getBookById(Long id){
        return bookRepository.findById(id).get();
    }
}
