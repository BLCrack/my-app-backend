package com.findme.myappbackend.controllers;

import com.findme.myappbackend.models.User;
import com.findme.myappbackend.models.UserCredentials;
import com.findme.myappbackend.security.TokenGenerator;
import com.findme.myappbackend.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    private UserService userService;
    private TokenGenerator tokenGenerator;

    public LoginController(UserService userService, TokenGenerator tokenGenerator) {
        this.userService = userService;
        this.tokenGenerator = tokenGenerator;
    }

    @PostMapping(produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> login(@RequestBody UserCredentials credentials) {
        User user = userService.findAllUsers().get(0);
        if (user != null && user.getPassword().equals(credentials.getPassword())) {
            String response = String.format("{ \"token\" : \"%s\" }", tokenGenerator.token(credentials));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"error\" : \"Authentication failed\" }", HttpStatus.FORBIDDEN);
    }
}
