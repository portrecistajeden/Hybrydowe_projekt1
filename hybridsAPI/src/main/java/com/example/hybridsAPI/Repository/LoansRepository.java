package com.example.hybridsAPI.Repository;

import com.example.hybridsAPI.Models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoansRepository extends JpaRepository<Loan,Integer> {

    @Query("select l from Loan l where l.idUser=?1")
    List<Loan> findByUserID(@Param("idUser") int idUser);

    @Query("select l from Loan l where l.idBook=?1")
    Loan findByBookID(@Param("idBook") int idBook);
}
