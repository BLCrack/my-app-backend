package com.findme.myappbackend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.findme.myappbackend.models.UserCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;

@Service
public class TokenGenerator {

    @Value("${jwt.secret}")
    private Resource secretFile;
    private String key;

    @PostConstruct
    public void expandSecret() throws IOException {
        key = new String(Files.readAllBytes(secretFile.getFile().toPath()));
    }

    public String token(UserCredentials credentials) {
        String token = null;
        try {
            token = JWT.create()
                       .withSubject(credentials.getPassword())
                       .sign(Algorithm.HMAC512(key));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return token;
    }
}
