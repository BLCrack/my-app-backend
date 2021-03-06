package com.findme.myappbackend.repositories;

import com.findme.myappbackend.models.Location;
import org.springframework.data.repository.Repository;

public interface LocationRepository extends Repository<Location, String>
{
    Location save(Location location);

    Location findById(int id);
}
