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
    LocationService locationService;

    @PostMapping("/add")
    public Location addLocation(@RequestBody Location location)
    {
        System.out.println("add location");
        return locationService.addLocationToDatabase(location);
    }

    @PutMapping("/update/{id}")
    public Location updateLocation(@PathVariable("id") int id, @RequestBody Location location)
    {
        System.out.println("update location");
        return locationService.updateLocationInDatabase(id, location);
    }
}
