package com.library.backend.service;

import com.library.backend.model.Book;
import com.library.backend.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo){
        this.repo=repo;
    }

    public List<Book> getAllBooks(){
        return repo.findAll();
    }

    public Book saveBook(Book book){
        return repo.save(book);
    }

    public void deleteBookById(Long id){
        repo.deleteById(id);
    }

}
