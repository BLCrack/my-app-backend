package com.findme.myappbackend.repositories;

import com.findme.myappbackend.models.Device;
import com.findme.myappbackend.models.User;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface DeviceRepository extends Repository<Device, String>
{
    List<Device> findByOwner(User owner);
}
