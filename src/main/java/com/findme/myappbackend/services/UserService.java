package com.findme.myappbackend.services;

import com.findme.myappbackend.models.User;
import com.findme.myappbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    public User findUserByLogin(String login)
    {
        return userRepository.findByLogin(login);
    }

    public User addUserToDatabase(User user)
    {
        return userRepository.save(user);
    }

    public void deleteUserFromDatabase(String login)
    {
        User deletingUser = userRepository.findByLogin(login);

        userRepository.delete(deletingUser);
    }
}
