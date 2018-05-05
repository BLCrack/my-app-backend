package com.findme.myappbackend.controllers;

import java.util.List;

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

	//TESTY
	User user = new User("admin", "admin");
	//

	@GetMapping(value = "/all")
	public List<Device> showDevices()
	{
		System.out.println("show devices");
		//TESTY
		user.setId(1);
		//
		return deviceService.findAllForUser(user);
	}

	@PostMapping(value = "/add")
	public Device addDevice(@RequestBody Device device)
	{
		//1. DODANIE URZADZENIA DO UZYTKOWNIKA
		//TESTY
		user.addDevice(device);
		//
		return deviceService.addDeviceToDatabase(device);
	}
}
