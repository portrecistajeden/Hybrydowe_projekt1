package com.example.hybridsAPI.Repository;

import com.example.hybridsAPI.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("select b from Book b where b.title like :title%")
    List<Book> findByTitle(@Param("title") String title);

    @Query("select b from Book b where b.yearofpublishment=?1")
    List<Book> findByearofpublishment(@Param("yearofpublishment") int yearofpublishment);

    @Query("select b from Book b where b.authors like :author%")
    List<Book> findByAuthor(@Param("author") String author);

    @Query("select b from Book b where b.idBook=?1")
    Book findByID(@Param("idBook") int idBook);
}
