package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.model.MyBookList;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList,Long>{
    
}
