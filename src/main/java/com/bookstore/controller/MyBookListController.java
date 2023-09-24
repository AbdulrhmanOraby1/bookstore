package com.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.service.MyBookListService;

@Controller
public class MyBookListController {

    private final MyBookListService myBookService;

    MyBookListController(MyBookListService myBookService) {
        this.myBookService = myBookService;
    }

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") Long id){
        myBookService.deleteById(id);
        return "redirect:/myBooks";
    }
}
