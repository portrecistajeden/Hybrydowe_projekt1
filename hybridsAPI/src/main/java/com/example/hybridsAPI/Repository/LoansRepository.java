package com.example.hybridsAPI.Repository;

import com.example.hybridsAPI.Models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoansRepository extends JpaRepository<Loan,Integer> {

    @Query("select l from loan where l.id_user=?1")
    List<Loan> findByUserID(@Param("id_user") int id_user);
}
