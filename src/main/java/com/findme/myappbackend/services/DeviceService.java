package com.findme.myappbackend.services;

import java.util.List;

import com.findme.myappbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.findme.myappbackend.models.Device;
import com.findme.myappbackend.models.User;
import com.findme.myappbackend.repositories.DeviceRepository;

@Service
public class DeviceService {
	DeviceRepository deviceRepository;
	UserRepository userRepository;

	@Autowired
	public DeviceService(DeviceRepository deviceRepository, UserRepository userRepository) {
		this.deviceRepository = deviceRepository;
		this.userRepository = userRepository;
	}

	public List<Device> findAllForCurrentUser()
	{
		User user = userRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		List<Device> devices = deviceRepository.findByOwner(user);
		return devices;
	}

	public Device addDeviceToDatabase(Device device)
	{
		return deviceRepository.save(device);
	}

	//usuwanie urządzenia
}
