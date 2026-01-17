package com.library.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "issues")
public class Issue {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="book_id",nullable=false)
    private Book book;

    @Column(name="student_name")
    private String studentName;

    private String status;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }

    public Book getBook(){
        return book;
    }
    public void setBook(Book book){
        this.book=book;
    }

    public String getStudentName(){
        return studentName;
    }
    public void setStudentName(String studentName){
        this.studentName=studentName;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }

}
