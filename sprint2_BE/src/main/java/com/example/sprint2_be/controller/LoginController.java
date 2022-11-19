package com.example.sprint2_be.controller;

import com.example.sprint2_be.repository.payload.request.LoginRequest;
import com.example.sprint2_be.repository.payload.response.JwtResponse;
import com.example.sprint2_be.security.jwt.JwtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
//@RequestMapping("auth/login")
public class LoginController {
    @Autowired
    private JwtServiceImpl jwtService;

    @PostMapping({"/auth/login"})
    public JwtResponse createJwtToken(@RequestBody LoginRequest loginRequest) throws Exception {
        return jwtService.createJwtToken(loginRequest);
    }
}
