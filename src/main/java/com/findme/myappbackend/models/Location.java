package com.findme.myappbackend.models;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "GPS_latitude")
	private float GPS_latitude;

	@Column(name = "GPS_longitude")
	private float GPS_longitude;

	@Column(name = "date")
	private Date date;

	@Column(name = "time")
	private Time time;

	@ManyToOne
	private Device device;

	public Location() {
		super();
	}

	public void setId(int id) {
		this.id = id;
	}

	public Location(float GPS_latitude, float GPS_longitude, Date date, Time time) {
		this.GPS_latitude = GPS_latitude;
		this.GPS_longitude = GPS_longitude;
		this.date = date;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public float getGPS_latitude() {
		return GPS_latitude;
	}

	public void setGPS_latitude(float GPS_latitude) {
		this.GPS_latitude = GPS_latitude;
	}

	public float getGPS_longitude() {
		return GPS_longitude;
	}

	public void setGPS_longitude(float GPS_longitude) {
		this.GPS_longitude = GPS_longitude;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
}
