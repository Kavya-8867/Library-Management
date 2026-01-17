package com.library.backend.controller;

import com.library.backend.model.Issue;
import com.library.backend.service.IssueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issues")
@CrossOrigin("http://localhost:3000")
public class IssueController {

    private final IssueService service;

    public IssueController(IssueService service){
        this.service=service;
    }

    @PostMapping("/issue")
    public Issue issueBook(@RequestParam Long bookId, @RequestParam String studentName){
        return service.issueBook(bookId,studentName);
    }

    @PostMapping("/return/{id}")
    public Issue returnBook(@PathVariable Long id){
        return service.returnBook(id);
    }

    @GetMapping
    public List<Issue> getAllIssues(){
        return service.getAllIssues();
    }

}
