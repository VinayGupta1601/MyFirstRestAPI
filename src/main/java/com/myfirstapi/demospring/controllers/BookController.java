package com.myfirstapi.demospring.controllers;

import com.myfirstapi.demospring.entities.Book;
import com.myfirstapi.demospring.services.BookService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class BookController {

    Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping("/books") //get all
    public List<Book> getBooks()
    {
        logger.info("getAllBooks method Accessed!!");
        return this.bookService.getAllBooks();

    }

    @GetMapping("/books/{id}") //get by id
    public Book getBook(@PathVariable("id") int id)
    {
        logger.info("getBookById method Accessed!!");
        return bookService.getBookById(id);

    }

    @PostMapping("/books") //add object
    public Book addBook(@RequestBody Book book)
    {
        logger.trace("addBook method Accessed!!");
        Book b = this.bookService.addBook(book);
        return b;
    }

    @DeleteMapping("/books/{id}") //delete
    public String deleteBook(@PathVariable("id") int id)
    {
        logger.trace("deleteBook method Accessed!!");
        this.bookService.deleteBook(id);
        return "Deleted";
    }

    @PutMapping("/books/{id}") //update
    public Book updateBook(@RequestBody Book book ,@PathVariable("id") int id)
    {
        this.bookService.updateBook(book,id);
        return book;
    }

}
