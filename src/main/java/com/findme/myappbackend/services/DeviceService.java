package com.findme.myappbackend.services;

import com.findme.myappbackend.models.Device;
import com.findme.myappbackend.models.Location;
import com.findme.myappbackend.models.User;
import com.findme.myappbackend.repositories.DeviceRepository;
import com.findme.myappbackend.repositories.LocationRepository;
import com.findme.myappbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
	DeviceRepository deviceRepository;
	UserRepository userRepository;
	LocationRepository locationRepository;

	@Autowired
	public DeviceService(DeviceRepository deviceRepository, UserRepository userRepository, LocationRepository locationRepository) {
		this.deviceRepository = deviceRepository;
		this.userRepository = userRepository;
		this.locationRepository = locationRepository;
	}

	public synchronized void updateLocation(int deviceId, Location location) {
		Device device = this.deviceRepository.findById(deviceId);
		if (device != null) {
			this.locationRepository.save(location);
			device.setActualLocation(location);
			this.deviceRepository.save(device);
		}
	}

	public List<Device> findAllDevicesForCurrentUser() {
		User user = userRepository.findByLogin(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
		List<Device> devices = deviceRepository.findByOwner(user);
		return devices;
	}

	public List<Device> findAllDevices()
	{
		List<Device> devices = deviceRepository.findAll();
		return devices;
	}

	public Device addDeviceToDatabase(Device device)
	{
		return deviceRepository.save(device);
	}

	//usuwanie urządzenia
}
