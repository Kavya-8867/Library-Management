package com.library.backend.service;

import com.library.backend.model.Book;
import com.library.backend.model.Issue;
import com.library.backend.repository.BookRepository;
import com.library.backend.repository.IssueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {

    private final IssueRepository issueRepo;
    private final BookRepository bookRepo;

    public IssueService(IssueRepository issueRepo,BookRepository bookRepo){
        this.issueRepo=issueRepo;
        this.bookRepo=bookRepo;
    }

    public Issue issueBook(Long bookId, String studentName){
        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getAvailableCopies() <= 0) {
            throw new RuntimeException("No copies available");
        }

        book.setAvailableCopies(book.getAvailableCopies()-1);
        bookRepo.save(book);

        Issue issue=new Issue();
        issue.setBook(book);
        issue.setStudentName(studentName);
        issue.setStatus("Issued");

        return issueRepo.save(issue);

    }

    public Issue returnBook(Long issueId){
        Issue issue=issueRepo.findById(issueId).orElseThrow();
        issue.setStatus("Returned");

        Book book=issue.getBook();
        book.setAvailableCopies(book.getAvailableCopies()+1);
        bookRepo.save(book);

        return issueRepo.save(issue);
    }

    public List<Issue> getAllIssues() {
        return issueRepo.findAll();
    }
}
