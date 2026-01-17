package com.library.backend.controller;

import com.library.backend.model.Book;
import com.library.backend.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("http://localhost:3000")
public class BookController {

    private final BookService service;

    public BookController(BookService service){
        this.service=service;
    }

    @GetMapping
    public List<Book> getBooks(){
        return service.getAllBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return service.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id){
        service.deleteBookById(id);
        return "Deleted successfully";
    }
}
