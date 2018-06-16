package com.findme.myappbackend.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.findme.myappbackend.models.UserCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Service
public class TokenGenerator {

    private final ResourceLoader resourceLoader;

    public TokenGenerator(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${jwt.secret}")
    private String secretFile;
    private String key;

    @PostConstruct
    public void expandSecret() throws IOException {
        key = StreamUtils.copyToString(resourceLoader.getResource(secretFile).getInputStream(), StandardCharsets.UTF_8);
    }

    public String token(UserCredentials credentials) {
        String token = null;
        try {
            token = JWT.create()
                    .withSubject(credentials.getUsername())
                    .sign(Algorithm.HMAC512(key));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return token;
    }
}
