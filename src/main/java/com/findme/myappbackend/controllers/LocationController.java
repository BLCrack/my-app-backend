package com.findme.myappbackend.controllers;

import com.findme.myappbackend.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController
{
    @Autowired
    LocationService locationService;
}
