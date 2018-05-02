package com.findme.myappbackend.repositories;

import com.findme.myappbackend.models.User;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<User, String>
{
    List<User> findAll();

    User findByLogin(String login);

    User save(User user);

    void delete(User user);
}

