package com.findme.myappbackend.controllers;

import com.findme.myappbackend.models.User;
import com.findme.myappbackend.models.UserCredentials;
import com.findme.myappbackend.security.TokenGenerator;
import com.findme.myappbackend.services.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.TokenService;
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

    @PostMapping
    public String login(@RequestBody UserCredentials credentials) {
        User user = userService.findUserByLogin(credentials.getUsername());
        if (user != null && user.getPassword().equals(credentials.getPassword())) {
            Authentication authentication = new UsernamePasswordAuthenticationToken(credentials.getUsername(),
                    credentials.getPassword());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return String.format("{ \"token\" : \"%s\" }", tokenGenerator.token(credentials));
        }
        return null;
    }
}
