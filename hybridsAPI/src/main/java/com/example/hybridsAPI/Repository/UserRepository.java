package com.example.hybridsAPI.Repository;

import com.example.hybridsAPI.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.login like :login%")
    User findByLogin(@Param("login") String login);

    @Query("select u from User u where u.login like :login and u.password like :password")
    User logging(@Param("login")String login, @Param("password") String password);
}
