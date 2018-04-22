package com.findme.myappbackend.controllers;

import com.findme.myappbackend.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController
{
    @Autowired
    LocationRepository locationRepository;
}
