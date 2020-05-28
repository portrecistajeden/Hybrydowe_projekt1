package com.example.hybridsAPI.Repository;

import com.example.hybridsAPI.Models.Book;
import com.example.hybridsAPI.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query("select r from role where r.role like :name%")
    Role findByName(@Param("name") String name);
}
