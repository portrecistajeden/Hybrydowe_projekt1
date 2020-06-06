package com.example.hybridsAPI.Models;

import org.codehaus.plexus.component.annotations.Requirement;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "book")
@EntityListeners(AuditingEntityListener.class)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idBook;

    @Requirement
    @Column(name = "authors", nullable = false)
    private String authors;

    @Requirement
    @Column(name = "title", nullable = false)
    private String title;

    @Requirement
    @Column(name = "yearofpublishment", nullable = false)
    private int yearofpublishment;

    public Book(Integer idBook, String authors, String title, int year){
        this.idBook=idBook;
        this.authors=authors;
        this.title=title;
        this.yearofpublishment=year;
    }

    public Book(){
        super();
    }
    public Integer getIdBook() {
        return idBook;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public int getYearofpublishment() {
        return yearofpublishment;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setYearofpublishment(int yearofpublishment) {
        this.yearofpublishment = yearofpublishment;
    }
}
