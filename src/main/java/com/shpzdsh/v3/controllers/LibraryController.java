package com.shpzdsh.v3.controllers;

import com.shpzdsh.v3.exceptions.BookNotFoundException;
import com.shpzdsh.v3.models.Library;
import com.shpzdsh.v3.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/app")
public class LibraryController {
    LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping(value = "/books")
    public List<Library> getAllBooks() {
        return libraryService.getAllBooks();
    }

    @GetMapping(value = "/books/{id}")
    public Library getBookById(@Valid @PathVariable("id") @Min(1) int id_book) {
        Library book = libraryService.findById(id_book).orElseThrow(() -> new BookNotFoundException("Book with " + id_book + "is not found"));
        return book;
    }

    @PostMapping(value = "/books")
    public Library addBook(@Valid @RequestBody Library library) {
        return libraryService.save(library);
    }

    @PutMapping(value = "/books/{id}")
    public Library updateBook(@Valid @PathVariable("id") @Min(1) int id_book, @Valid @RequestBody Library newbook) {
        Library libraryUpdate = libraryService.findById(id_book).orElseThrow(() -> new BookNotFoundException("Book with " + id_book + "is not found"));
        libraryUpdate.setName_book(newbook.getName_book());
        libraryUpdate.setAuthor_book(newbook.getAuthor_book());
        libraryUpdate.setYear_book((newbook.getYear_book()));
        libraryUpdate.setQuantity(newbook.getQuantity());
        return libraryService.save(libraryUpdate);
    }

    @DeleteMapping(value = "/books/{id}")
    public String deleteBook(@PathVariable("id") @Min(1) int id_book) {
        Library book = libraryService.findById(id_book).orElseThrow(() -> new BookNotFoundException("Book with " + id_book + "is not found"));
        libraryService.deleteById(book.getId_book());
        return "Books with id " + id_book + " is deleted";
    }

}
