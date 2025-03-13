package com.example.h2exemple.controller;

import com.example.h2exemple.model.Book;
import com.example.h2exemple.repository.BookRepository;
import com.example.h2exemple.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;


    //ALL
    @GetMapping("/books")
    public Iterable<Book> getAllBooks() {
        return bookService.findAll();
    }

    //BY ID
    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/books/add")
    public Book addBook(Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/books/update")
    public Book updateBook(Book book, @PathVariable Long id) {
        //return bookService.updateBook(book)
    }

    @GetMapping("books/delete")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }
}
