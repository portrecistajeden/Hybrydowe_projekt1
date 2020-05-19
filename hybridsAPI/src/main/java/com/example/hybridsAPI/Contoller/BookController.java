package com.example.hybridsAPI.Contoller;

import com.example.hybridsAPI.Models.Book;
import com.example.hybridsAPI.Repository.BookRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookbyId(@PathVariable(value = "id") int idbook)
            throws ResourceNotFoundException {
        Book book = bookRepository
                .findById(idbook)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found on ::" + idbook));
        return ResponseEntity.ok().body(book);
    }

    @GetMapping("/books/title")
    public Book getByTitle(@RequestParam String title)
    {
            Book book=bookRepository
                    .findByTitle(title);

            return book;
    }


    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }


    @DeleteMapping("/books/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") Integer id) throws Exception {
        Book book =
                bookRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));
        bookRepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted book "+book.getTitle(), Boolean.TRUE);
        return response;
    }

    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }



}