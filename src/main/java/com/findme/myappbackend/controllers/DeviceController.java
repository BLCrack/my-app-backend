package com.findme.myappbackend.controllers;

import java.util.List;

import com.findme.myappbackend.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.findme.myappbackend.models.Device;
import com.findme.myappbackend.models.User;
import com.findme.myappbackend.services.DeviceService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class DeviceController {
	@Autowired
	DeviceService deviceService;

	//TESTY
	User user = new User("admin", "admin");
	//

	@GetMapping(value = "/devices")
	public List<Device> showDevices()
	{
		//TESTY
		user.setId(1);
		//
		return deviceService.findAllForUser(user);
	}

	@PostMapping(value = "/adddevice")
	public Device addDevice(Device device)
	{
		//1. DODANIE URZADZENIA DO UZYTKOWNIKA
        //2. POBRANIE AKTUALNEJ LOKACJI W TELEFONIE, ZAPISANIE JEJ JAKO BIEZACJE DLA URZADZENIA I ZAPISANIE ROWNIEZ DO HISTORII LOKACJI URZADZENIA
		//TESTY
		user.addDevice(device);
		//
		return deviceService.addDeviceToDatabase(device);
	}
}
