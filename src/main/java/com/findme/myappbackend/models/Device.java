package com.findme.myappbackend.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "devices")
public class Device {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "connectionName")
	private String connectionName;

	@Column(name = "deviceName")
	private String deviceName;

	@Column(name = "startConnection")
	private Date startConnection;

	@OneToOne
	private Location actualLocation;

	@ManyToOne
	@JsonIgnoreProperties({ "devices" })
	private User owner;

	public Device() {
		super();
	}

	public Device(String phoneNumber, String connectionName, String deviceName, Date startConnection, Location actualLocation, User owner) {
		this.phoneNumber = phoneNumber;
		this.connectionName = connectionName;
		this.deviceName = deviceName;
		this.startConnection = startConnection;
		this.actualLocation = actualLocation;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getConnectionName() {
		return connectionName;
	}

	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public Date getStartConnection() {
		return startConnection;
	}

	public void setStartConnection(Date startConnection) {
		this.startConnection = startConnection;
	}

	public Location getActualLocation() {
		return actualLocation;
	}

	public void setActualLocation(Location actualLocation) {
		this.actualLocation = actualLocation;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
}
