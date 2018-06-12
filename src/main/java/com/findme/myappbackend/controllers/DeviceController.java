package com.findme.myappbackend.controllers;

import java.util.List;

import com.findme.myappbackend.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.findme.myappbackend.models.Device;
import com.findme.myappbackend.models.User;
import com.findme.myappbackend.services.DeviceService;

@RestController
@RequestMapping("/devices")
@CrossOrigin
public class DeviceController {
	@Autowired
	DeviceService deviceService;

	@GetMapping(value = "/forcurrentuser")
	public List<Device> showDevicesForCurrentUser()
	{
		System.out.println("show devices for current user");
		return deviceService.findAllDevicesForCurrentUser();
	}

	@GetMapping(value = "/all")
	public List<Device> showDevices()
	{
		System.out.println("show devices");
		return deviceService.findAllDevices();
	}

	@PostMapping(value = "/add")
	public Device addDevice(@RequestBody Device device)
	{
		System.out.println("add device");
		return deviceService.addDeviceToDatabase(device);
	}

	@PutMapping("/update/location/{id}")
	public Location updateLocation(@PathVariable("id") int deviceId, @RequestBody Location location)
	{
		System.out.println("update location for device " + deviceId);
		deviceService.updateLocation(deviceId, location);
		return location;
	}
}
