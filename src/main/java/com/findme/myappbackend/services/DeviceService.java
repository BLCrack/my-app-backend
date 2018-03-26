package com.findme.myappbackend.services;

import com.findme.myappbackend.models.Device;
import com.findme.myappbackend.models.User;
import com.findme.myappbackend.repositories.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService
{
    DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository)
    {
        this.deviceRepository=deviceRepository;
    }

    public List<Device> findAllForUser(User user)
    {
        return deviceRepository.findByOwner(user);
    }
}
