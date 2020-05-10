package com.example.hybridsAPI.Contoller;

import com.example.hybridsAPI.Models.Book;
import com.example.hybridsAPI.Repository.BookRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookbyId(@PathVariable(value = "id") Long idbook)
        throws ResourceNotFoundException{
            Book book=bookRepository
                    .findById(idbook)
                    .orElseThrow(()->new ResourceNotFoundException("Book not found on ::"+idbook));
        return ResponseEntity.ok().body(book);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }


    }
