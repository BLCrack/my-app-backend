package com.findme.myappbackend.controllers;

import com.findme.myappbackend.models.Device;
import com.findme.myappbackend.models.Location;
import com.findme.myappbackend.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController
{
    @Autowired
    DeviceRepository deviceRepository;

    @GetMapping(value = "/devices")
    public Iterable<Device> showDevices()
    {
        return deviceRepository.findAll();
    }
}
