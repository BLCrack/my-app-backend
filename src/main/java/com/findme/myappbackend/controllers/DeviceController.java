package com.findme.myappbackend.controllers;

import com.findme.myappbackend.models.Device;
import com.findme.myappbackend.models.User;
import com.findme.myappbackend.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeviceController
{
    @Autowired
    DeviceService deviceService;

    User user = new User("admin", "admin");

    @GetMapping(value = "/devices")
    public List<Device> showDevices()
    {
       return deviceService.findAllForUser(user);
    }
}
