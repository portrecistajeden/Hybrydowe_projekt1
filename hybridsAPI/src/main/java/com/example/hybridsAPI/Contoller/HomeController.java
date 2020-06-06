package com.example.hybridsAPI.Contoller;

import com.example.hybridsAPI.Models.AuthRequest;
import com.example.hybridsAPI.config.JwtUtil;
import com.example.hybridsAPI.config.SecurityConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Import(SecurityConfigurer.class)
@RestController
public class HomeController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String index(){
        return "Home page";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest)throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword())
            );
        } catch (Exception ex){
            throw new Exception("Invalid login or password");
        }
        return jwtUtil.generateToken(authRequest.getLogin());
    }
}
