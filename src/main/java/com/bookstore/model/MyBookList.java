package com.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MyBooks")
public class MyBookList {

    @Id
    private Long id;
    private String name;
    private String author;
    private Integer price;
    private String usr_role;

    public MyBookList(Long id, String name, String author, Integer price, String usr_role) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.usr_role = usr_role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getUsr_role() {
        return usr_role;
    }

    public void setUsr_role(String usr_role) {
        this.usr_role = usr_role;
    }

    public MyBookList() {
    }
    
    
}
