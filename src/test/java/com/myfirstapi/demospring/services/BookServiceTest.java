package com.myfirstapi.demospring.services;

import com.myfirstapi.demospring.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BookServiceTest {

    @Autowired
    public BookService bookService;


    @Test
    void getAllBooks() {

        List<Book> list=new ArrayList<>();
        Book b1 = new Book(10,"kafan","premchand");
        Book b2 = new Book(11,"Indore","Mayur");
        list.add(b1);
        list.add(b2);
        //assertThat(list).containsAll(b1);

    }


}