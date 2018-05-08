package com.findme.myappbackend.controllers;

import com.findme.myappbackend.models.User;
import com.findme.myappbackend.repositories.UserRepository;
import com.findme.myappbackend.services.DeviceService;
import com.findme.myappbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping(value = "/all")
    public List<User> showUsers()
    {
        return userService.findAllUsers();
    }

    @GetMapping(value = "/{login}")
    public User showUser(@PathVariable String login)
    {
        return userService.findUserByLogin(login);
    }

    @PostMapping(value = "/newuser")
    public User addUser(User user)
    {
        return userService.addUserToDatabase(user);
    }

    @DeleteMapping(value = "/{login}")
    public void deleteUser(@PathVariable String login)
    {
        userService.deleteUserFromDatabase(login);
    }
}
