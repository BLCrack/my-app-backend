package com.findme.myappbackend.controllers;

import com.findme.myappbackend.models.User;
import com.findme.myappbackend.repositories.UserRepository;
import com.findme.myappbackend.services.DeviceService;
import com.findme.myappbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class.getCanonicalName());

    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping(value = "/all")
    public List<User> showUsers()
    {
        System.out.println("showUsers");
        return userService.findAllUsers();
    }

    @GetMapping(value = "/{login}")
    public User showUser(@PathVariable String login) {
        System.out.println("showUserByLogin");
        return userService.findUserByLogin(login);
    }

    @PostMapping(value = "/add")
    public User addUser(@RequestBody User user) {
        logger.info("addUser : " + user);
        return userService.addUserToDatabase(user);
    }

    @DeleteMapping(value = "/{login}")
    public void deleteUser(@PathVariable String login) {
        userService.deleteUserFromDatabase(login);
    }
}
