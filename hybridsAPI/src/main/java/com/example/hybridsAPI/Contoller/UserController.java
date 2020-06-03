package com.example.hybridsAPI.Contoller;

import com.example.hybridsAPI.Models.Loan;
import com.example.hybridsAPI.Models.User;
import com.example.hybridsAPI.Repository.LoansRepository;
import com.example.hybridsAPI.Repository.RoleRepository;
import com.example.hybridsAPI.Repository.UserRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Integer idUser)
        throws ResourceNotFoundException{
        User user = userRepository
                .findById(idUser)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + idUser));
        return ResponseEntity.ok().body(user);
    }



    @PostMapping("/users") //create normalUser
    public User createUser(@Valid @RequestBody User user){
        user.setRole(roleRepository.findByName("ROLE_USER"));
        return userRepository.save(user);
    }


    @PutMapping("/users/{id}") //update login, password, role
    public ResponseEntity<User> updateUser(
            @PathVariable(value = "id") Integer idUser,
            @Valid @RequestBody User userDetails)
        throws ResourceNotFoundException {
        User user = userRepository
                .findById(idUser)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + idUser));

        user.setLogin(userDetails.getLogin());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }


    @DeleteMapping("users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Integer idUser)
        throws Exception {
        User user = userRepository
                .findById(idUser)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + idUser));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
