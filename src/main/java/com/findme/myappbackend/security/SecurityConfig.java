package com.findme.myappbackend.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StreamUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ResourceLoader resourceLoader;

    @Value("${jwt.secret}")
    private String secretFile;

    private String key;

    public SecurityConfig(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @PostConstruct
    public void expandSecret() throws IOException {
        key = StreamUtils.copyToString(resourceLoader.getResource(secretFile).getInputStream(), StandardCharsets.UTF_8);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().cors().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(key);
    }
}