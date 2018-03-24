package com.findme.myappbackend.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="locations")
public class Location
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name="GPS_latitude")
    private String GPS_latitude;

    @Column(name="GPS_longitude")
    private String GPS_longitude;

    @Column(name="date")
    private Date date;

    @Column(name="time")
    private Time time;

    public Location(String GPS_latitude, String GPS_longitude, Date date, Time time)
    {
        this.GPS_latitude=GPS_latitude;
        this.GPS_longitude=GPS_longitude;
        this.date=date;
        this.time=time;
    }

    public String getId()
    {
        return id;
    }

    public String getGPS_latitude()
    {
        return GPS_latitude;
    }

    public void setGPS_latitude(String GPS_latitude)
    {
        this.GPS_latitude = GPS_latitude;
    }

    public String getGPS_longitude()
    {
        return GPS_longitude;
    }

    public void setGPS_longitude(String GPS_longitude)
    {
        this.GPS_longitude = GPS_longitude;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Time getTime()
    {
        return time;
    }

    public void setTime(Time time)
    {
        this.time = time;
    }
}
