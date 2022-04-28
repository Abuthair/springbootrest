package com.bookapp.controllers;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private IBookService iBookService;
//http://localhost:8080/books
    @GetMapping("/books")
    public List<Book> showBooks(){
        return iBookService.getAll();
    }
    //http://localhost:8080/books/author/abu
    @GetMapping("/books/author/{myauthor}")
    public List<Book> showByAuthor(@PathVariable("myauthor")String author){
        return iBookService.findByAuthor(author);
    }
    //
    @GetMapping("/books/{category}")
    public List<Book> showByCategory(@RequestParam("category")String category){
        return iBookService.findByCategory(category);
    }
    @GetMapping("/books/price/{price}")
    public List<Book> showByPrice(@PathVariable("price")double price){
        return iBookService.findByLesserPrice(price);
    }
    @GetMapping("/books/id/{bookId}")
    public Book showById(@PathVariable("bookId")int id){
        return iBookService.getById(id);
    }
}
