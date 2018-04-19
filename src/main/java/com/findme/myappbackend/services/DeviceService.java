package com.findme.myappbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findme.myappbackend.models.Device;
import com.findme.myappbackend.models.User;
import com.findme.myappbackend.repositories.DeviceRepository;

@Service
public class DeviceService {
	DeviceRepository deviceRepository;

	@Autowired
	public DeviceService(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}

	public List<Device> findAllForUser(User user) {
		List<Device> devices = deviceRepository.findByOwner(user);
		return devices;
	}
}
