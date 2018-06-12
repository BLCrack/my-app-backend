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

    public Location findLocationById(int id) { return locationRepository.findById(id); }

    public Location updateLocationInDatabase(int id, Location location)
    {
        Location currentLocation = locationRepository.findById(id);

        currentLocation.setId(location.getId());
        currentLocation.setDate(location.getDate());
        currentLocation.setTime(location.getTime());
        currentLocation.setGpsLatitude(location.getGpsLatitude());
        currentLocation.setGpsLongitude(location.getGpsLongitude());
        //currentLocation.setDevice(location.getDevice());

        return locationRepository.save(currentLocation);
    }


}
