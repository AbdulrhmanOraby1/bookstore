package com.bookstore.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bookstore.model.Book;
import com.bookstore.model.MyBookList;
import com.bookstore.service.BookService;
import com.bookstore.service.MyBookListService;



@RestController
@RequestMapping("/api/index")
public class BookController {
    
    @Autowired private final BookService bookService;

    private final MyBookListService myBookService;

    public BookController(BookService bookService, MyBookListService myBookService) {
        this.bookService = bookService;
        this.myBookService = myBookService;
    }

    @Transactional
    @GetMapping("/booklist")
    public String viewHomePage (Model model){
        model.addAttribute("allboklist", bookService.getAllBooks());
        return "redirect:/booklist";
    }
    
    // @GetMapping("/booklist")
    // public ModelAndView getAllBooks(){
    //      List<Book>list=bookService.getAllBooks();
    //      return new ModelAndView("booklist","book",list);
    // }
    
    @PostMapping("/save")
    public String addBook(@ModelAttribute Book bok){
        bookService.save(bok);
        return "redirect:/booklist";
    }

    @GetMapping("/my_books")
        public String getMyBooks(Model model){
            List<MyBookList>list=myBookService.getAllMyBooks();
            model.addAttribute("allboklist",list);
            return "redirect:/myBooks";
        }

    @RequestMapping("/mylist/{id}")
        public String getMyList(@PathVariable("id") Long id){
            Book bok=bookService.getBookById(id);
            MyBookList mb=new MyBookList(bok.getId(),bok.getName(),bok.getAuthor(),bok.getPrice(),bok.getUsr_role());
            myBookService.saveMyBooks(mb);
            return "redirect:/myBooks";
        }
    
}