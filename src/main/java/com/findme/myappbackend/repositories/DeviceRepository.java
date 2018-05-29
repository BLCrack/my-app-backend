package com.findme.myappbackend.repositories;

import com.findme.myappbackend.models.Device;
import com.findme.myappbackend.models.User;
import org.springframework.data.repository.Repository;


import java.util.List;
import java.util.Set;

public interface DeviceRepository extends Repository<Device, String>
{
    List<Device> findByOwner(User owner);

    List<Device> findAll();

    Device save(Device device);

    void delete(Device device);
}
