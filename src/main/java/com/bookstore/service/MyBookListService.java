package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookstore.model.MyBookList;
import com.bookstore.repository.MyBookRepository;

@Service
public class MyBookListService {
   @Autowired private MyBookRepository myBookRepository;

   public void saveMyBooks(MyBookList book){
    myBookRepository.save(book);
   }

   public List<MyBookList> getAllMyBooks(){
        return myBookRepository.findAll();
   }

   public void deleteById(long id)
    {
        myBookRepository.deleteById(id);
    }
}
