package com.myfirstapi.demospring.services;
import com.myfirstapi.demospring.entities.Book;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {

    private static List<Book> list=new ArrayList<>();
    static {
        list.add(new Book(1,"Titanic","vinay"));
        list.add(new Book(2,"India","sahil"));
        list.add(new Book(3,"Mountains","Tarun"));
        list.add(new Book(4,"Bazigar","aditya"));
        list.add(new Book(5,"Patang","chanchal"));
    }

    //get all books
    public List<Book> getAllBooks()
    {
        return list;
    }

    //get book by id
    public Book getBookById(int id)
    {
        Book book = null;
        book = list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }

    //post: add a book
    public Book addBook(Book b)
    {
        list.add(b);
        return b;
    }

    //delete: method
    public void deleteBook(int id)
    {
        list = list.stream().filter(book-> {
            if(book.getId() != id)
            {
                return true;
            }
            else {
                return false;
            }
        }).collect(Collectors.toList());
    }
    // if the id matches then we will leave it
    // otherwise will copy to it another list

    //put:update the book
    public void updateBook(Book book, int id)
    {
        list = list.stream().map(b-> {
            if(b.getId() == book.getId())
            {
                b.setAuthor(book.getAuthor());
                b.setTitle(book.getTitle());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
