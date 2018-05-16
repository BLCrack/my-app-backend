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

	@Column(name = "gpsLatitude")
	private float gpsLatitude;

	@Column(name = "gpsLongitude")
	private float gpsLongitude;

	@Column(name = "date")
	private Date date;

	@Column(name = "time")
	private Time time;

	@OneToOne
	private Device device;

	public Location() {
		super();
	}

	public void setId(int id) {
		this.id = id;
	}

	public Location(float gpsLatitude, float gpsLongitude, Date date, Time time) {
		this.gpsLatitude = gpsLatitude;
		this.gpsLongitude = gpsLongitude;
		this.date = date;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public float getGpsLatitude() {
		return gpsLatitude;
	}

	public void setGpsLatitude(float gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}

	public float getGpsLongitude() {
		return gpsLongitude;
	}

	public void setGpsLongitude(float gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
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
