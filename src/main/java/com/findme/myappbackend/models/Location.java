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


}
