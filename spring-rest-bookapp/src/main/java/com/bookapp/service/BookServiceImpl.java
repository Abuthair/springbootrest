package com.bookapp.service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookServiceImpl implements  IBookService{
    @Override
    public List<Book> getAll() {
        return showBooks();
    }

    @Override
    public List<Book> findByAuthor(String author) throws BookNotFoundException {
       List<Book> books=showBooks().stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
        if(books.isEmpty()) {
            throw new BookNotFoundException();
        } else
            return books;
    }

    @Override
    public List<Book> findByCategory(String category) throws BookNotFoundException {
        List<Book> books= showBooks().stream().filter(book -> book.getCategegory().equalsIgnoreCase(category)).sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
        if(books.isEmpty()) {
            throw new BookNotFoundException();
        } else
            return books;
    }

    @Override
    public List<Book> findByLesserPrice(double price) throws BookNotFoundException {
        List<Book> books= showBooks().stream().filter(book -> book.getPrice()<=price).sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
        if(books==null) {
            throw new BookNotFoundException();
        } else
            return books;
    }

    @Override
    public Book getById(int bookId) throws BookNotFoundException {
        return showBooks().stream().filter(book -> book.getBookId()==bookId).findAny().orElseThrow(()-> new BookNotFoundException());
    }
    private List<Book> showBooks(){
        return Arrays.asList(
                new Book(1,"java in action","kathy","tech",900),
                new Book(2,"skull daggery","jose","friction",2000),
                new Book(3,"spring fire","Abu","tech",1000),
                new Book(4,"Harry Potter","awadhrsh","action",700));

    }
}
