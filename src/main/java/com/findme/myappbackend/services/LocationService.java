package com.findme.myappbackend.services;

import com.findme.myappbackend.models.Location;
import com.findme.myappbackend.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService
{
    LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository)
    {
        this.locationRepository=locationRepository;
    }

    public Location addLocationToDatabase(Location location)
    {
        return locationRepository.save(location);
    }
}
