package com.example.hybridsAPI.Contoller;

import com.example.hybridsAPI.Models.Loan;
import com.example.hybridsAPI.Repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoansRepository loansRepository;

    @GetMapping("/loans")
    public List<Loan> getAllLoans(){
        return loansRepository.findAll();
    }

    @GetMapping("/loans/{id}") //zwraca wypozyczone ksiazki usera
    public List<Loan> getUserLoans(@PathVariable(value = "id") int id){

        List<Loan> loans = loansRepository
                .findByUserID(id);
        return loans;
    }
}
