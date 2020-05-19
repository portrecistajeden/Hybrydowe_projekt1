package com.example.hybridsAPI.Repository;

import com.example.hybridsAPI.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("select b from Book b where b.title like %:title%")
    Book findByTitle(@Param("title") String title);
}
