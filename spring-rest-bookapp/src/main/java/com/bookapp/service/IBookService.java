package com.bookapp.service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    List<Book> findByAuthor(String author)throws BookNotFoundException ;
    List<Book> findByCategory(String category)throws BookNotFoundException;
    List<Book> findByLesserPrice(double price) throws BookNotFoundException;
    Book getById(int bookId) throws BookNotFoundException;
}
