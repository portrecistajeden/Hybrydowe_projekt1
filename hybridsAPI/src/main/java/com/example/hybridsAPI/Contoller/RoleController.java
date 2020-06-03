package com.example.hybridsAPI.Contoller;

import com.example.hybridsAPI.Models.Book;
import com.example.hybridsAPI.Models.Role;
import com.example.hybridsAPI.Models.User;
import com.example.hybridsAPI.Repository.BookRepository;
import com.example.hybridsAPI.Repository.RoleRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    @PostMapping("/roles")
    public Role createRole(@Valid @RequestBody Role role){
        return roleRepository.save(role);
    }

    @DeleteMapping("roles/{id}")
    public Map<String, Boolean> deleteRole(@PathVariable(value = "id") Integer idRole)
            throws Exception {
        Role role= roleRepository
                .findById(idRole)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found on :: " + idRole));

        roleRepository.delete(role);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
