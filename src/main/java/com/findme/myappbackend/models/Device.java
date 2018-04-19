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

	@Column(name = "connection_name")
	private String connectionName;

	@Column(name = "device_name")
	private String deviceName;

	@Column(name = "history_days0")
	private int historyDays;

	@Column(name = "start_connection")
	private Date startConnection;

	@OneToOne
	private Location actualLocation;
	@OneToMany
	private List<Location> historyLocations = new ArrayList<>();

	@ManyToOne
	@JsonIgnoreProperties({ "devices" })
	private User owner;

	public Device() {
		super();
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

	public void setId(int id) {
		this.id = id;
	}

	public Device(String connectionName, String deviceName, int historyDays, Date startConnection) {
		this.connectionName = connectionName;
		this.deviceName = deviceName;
		this.historyDays = historyDays;
		this.startConnection = startConnection;
	}

	public int getId() {
		return this.id;
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

	public int getHistoryDays() {
		return historyDays;
	}

	public void setHistoryDays(int historyDays) {
		this.historyDays = historyDays;
	}

	public Date getStartConnection() {
		return startConnection;
	}

	public void setStartConnection(Date startConnection) {
		this.startConnection = startConnection;
	}

	public List<Location> getHistoryLocations() {
		return historyLocations;
	}

	public void setHistoryLocations(List<Location> historyLocations) {
		this.historyLocations = historyLocations;
		this.actualLocation = historyLocations.get(historyLocations.size() - 1);
	}

	public void addLocationToHistory(Location location) {
		this.historyLocations.add(location);
		this.actualLocation = historyLocations.get(historyLocations.size() - 1);
	}

}
