package com.findme.myappbackend.repositories;

import com.findme.myappbackend.models.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, String>
{
}
