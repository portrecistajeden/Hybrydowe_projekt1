package com.example.hybridsAPI.Contoller;

import com.example.hybridsAPI.Models.Book;
import com.example.hybridsAPI.Models.Role;
import com.example.hybridsAPI.Repository.BookRepository;
import com.example.hybridsAPI.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/roles")
    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }
}
