package com.findme.myappbackend.repositories;

import com.findme.myappbackend.models.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device, String>
{
}
