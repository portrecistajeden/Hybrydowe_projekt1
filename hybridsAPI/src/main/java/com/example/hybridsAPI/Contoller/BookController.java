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
import java.util.ArrayList;
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

    @GetMapping("/books/rented/{idUser}")
    public List<Book> getRentedUserBooks(@PathVariable("idUser") int idUser){
        List<Book> books = new ArrayList<>();
        List<Loan> userLoans = loansRepository.findByUserID(idUser);
        for (Loan loan : userLoans) {
            books.add(bookRepository.findByID(loan.getIdBook().getIdBook()));
        }
        return books;
    }

    @GetMapping("/books/available")
    public List<Book> getAvailableBooks(){
        List<Book> books = bookRepository.findAll();
        List<Book> booksAvailable = new ArrayList<>();
        List<Loan> userLoans = loansRepository.findAll();
        int pom=0;
        for(Book book:books){
            pom=0;
            for(Loan loan:userLoans){
                if(book.getIdBook()==loan.getIdBook().getIdBook()){
                    pom=1;
                }
            }
            if(pom==0){
                booksAvailable.add(book);
            }
        }
        return booksAvailable;
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

    @GetMapping("/books/authors/{authors}")
    public  List<Book> getByAuthors(@PathVariable(value = "authors") String authors)
    {
        List<Book> book=bookRepository
                .findByAuthor(authors);

        return book;
    }

    @DeleteMapping("/books/delete/{id}")
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

    @PostMapping("/books/create")
    public Book createBook( @RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PostMapping("/books/rent/{id}/{idUser}")
    public void rentBook(@PathVariable("id") int id, @PathVariable("idUser") int idUser) throws Exception {

        Loan loanSearch = loansRepository.findByBookID(id);
        if (loanSearch == null ||  loanSearch.getIdUser().getIdUser() != idUser) {
            Book book = bookRepository.findByID(id);
            User user = userRepository.findByID(idUser);

            System.out.println(book.getTitle());
            System.out.println(user.getLogin());

            Loan loan = new Loan();
            loan.setIdUser(user);
            loan.setIdBook(book);
            loansRepository.save(loan);
        }
    }
    @PostMapping("/books/return/{id}/{idUser}")
    public void returnBook (@PathVariable("id") int id, @PathVariable("idUser") int idUser){

        Loan loan = loansRepository.findByBookID(id);
        if(loan.getIdUser().getIdUser() == idUser)
            loansRepository.delete(loan);
    }

}