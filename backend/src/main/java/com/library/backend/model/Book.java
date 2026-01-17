package com.library.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;



@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String title;
    private int availableCopies;

    public void setId(Long id){
        this.id=id;
    }
    public Long getId() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAvailableCopies(){
        return availableCopies;
    }
    public void setAvailableCopies(int availableCopies){
        this.availableCopies=availableCopies;
    }

}
