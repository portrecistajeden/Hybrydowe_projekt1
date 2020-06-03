package com.example.hybridsAPI.Contoller;

import com.example.hybridsAPI.Models.Book;
import com.example.hybridsAPI.Models.Loan;
import com.example.hybridsAPI.Models.User;
import com.example.hybridsAPI.Repository.BookRepository;
import com.example.hybridsAPI.Repository.LoansRepository;
import com.example.hybridsAPI.Repository.UserRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LoansRepository loansRepository;

    @Autowired
    private UserRepository userRepository;

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

    @GetMapping("/books/title/{title}")
    public List<Book> getByTitle(@PathVariable(value = "title") String title)
    {
        List<Book> book=bookRepository
                .findByTitle(title.toUpperCase());

        return book;
    }

    @GetMapping("/books/year/{yearofpublishment}")
    public  List<Book> getByyearofpublishment(@PathVariable(value = "yearofpublishment") int yearofpublishment)
    {
        List<Book> book=bookRepository
                .findByearofpublishment(yearofpublishment);

        return book;
    }

    @GetMapping("/books/year/{author}")
    public  List<Book> getByAuthor(@PathVariable(value = "yearofpublishment") int yearofpublishment)
    {
        List<Book> book=bookRepository
                .findByearofpublishment(yearofpublishment);

        return book;
    }

    @DeleteMapping("/books/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") Integer id) throws Exception {
        Book book =
                bookRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Book not found on :: " + id));
        if(loansRepository.findByBookID(id) == null)
            bookRepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted book "+book.getTitle(), Boolean.TRUE);
        return response;
    }

    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("books/{id}/rent")
    public Map<String, Boolean> rentBook(@PathVariable(value = "id") int id, @RequestParam(value = "idUser") int idUser) throws Exception{

        Map<String, Boolean> response = new HashMap<>();

        if(loansRepository.findByBookID(id)==null && loansRepository.findByUserID(idUser)==null){
            Book book =
                    bookRepository
                            .findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Book not found on :: " + id));
            User user =
                    userRepository
                            .findById(idUser)
                            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));

            Loan loan = new Loan();
            loan.setIdUser(user);
            loan.setIdBook(book);
            loansRepository.save(loan);

            response.put("Rented a book " + book.getTitle(), Boolean.TRUE);
            return response;
        }
        response.put("Could not rent a book ", Boolean.TRUE);
        return response;
    }
}