package com.findme.myappbackend.controllers;

import com.findme.myappbackend.models.Location;
import com.findme.myappbackend.models.User;
import com.findme.myappbackend.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
@CrossOrigin
public class LocationController
{
    @Autowired
    LocationService locationService;

    User user = new User("admin", "admin");

    @PostMapping("/add")
    public Location addLocation(@RequestBody Location location)
    {
        return locationService.addLocationToDatabase(location);
    }
}
