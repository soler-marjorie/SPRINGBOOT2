package com.example.h2exemple.service;

import com.example.h2exemple.model.Book;
import com.example.h2exemple.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //ALL
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    //BY ID
    public Optional<Book> getBookById(Long id) {
        return Optional.ofNullable(bookRepository.findById(id).orElse(null));
    }

    //ADD METHOD
    public void addBook() {
        Book book = new Book();
        Scanner sc = new Scanner(System.in);

        System.out.println("Titre du livre : ");
        book.setTitre(sc.nextLine());

        System.out.println("description du livre : ");
        book.setDescription(sc.nextLine());

        System.out.println("Date de publication du livre : ");
        book.setDatePublication(sc.nextLine());

        bookList.add(book);
    }

    //REMOVE METHOD BY ID
    public void remove() {
        System.out.println("Quel titre voulez vous supprimer ?");
        Scanner sc = new Scanner(System.in);

        String titre = sc.nextLine();
        for (Book book : bookList) {
            if (book.getTitre().equals(titre)) {
                bookList.remove(book);
                break;
            }
        }
    }

    //DELETE METHOD
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    //UPDATE METHOD
    public Optional<Book> updateBookById(Long id, Book book) {
        Optional<Book> bookToUpdate = bookRepository.findById(id);

        if(bookToUpdate.isPresent()) {
            bookToUpdate.get().setTitre(book.getTitre());
            bookToUpdate.get().setDescription(book.getDescription());
            bookToUpdate.get().setDatePublication(book.getDatePublication());
            return Optional.of(bookRepository.save(bookToUpdate.get()));
        }
        return Optional.empty();
    }
}
