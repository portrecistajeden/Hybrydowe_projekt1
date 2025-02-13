package com.example.hybridsAPI.Models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "loan")
@EntityListeners(AuditingEntityListener.class)
public class Loan {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer idLoan;

    @ManyToOne
    @JoinColumn(name = "idBook")
    private Book idBook;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User idUser;

    public Loan(Integer idLoan){
        this.idLoan=idLoan;
    }

    public Loan() {super();}

    public Integer getIdLoan() {
        return idLoan;
    }

    public Book getIdBook() {
        return idBook;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public void setIdBook(Book idBook) {
        this.idBook = idBook;
    }

    public void setIdLoan(Integer idLoan) {
        this.idLoan = idLoan;
    }
}
