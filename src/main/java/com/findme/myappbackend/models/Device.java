package com.findme.myappbackend.models;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "devices")
public class Device
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="connection_name")
    private String connectionName;

    @Column(name="device_name")
    private String deviceName;

    @Column(name="history_days0")
    private int historyDays;

    @Column(name="start_connection")
    private Date startConnection;

    public Device()
    {
        this.connectionName=connectionName;
        this.deviceName=deviceName;
        this.historyDays=historyDays;
        this.startConnection=startConnection;
    }

    public int getId()
    {
        return this.id;
    }

    public String getConnectionName()
    {
        return connectionName;
    }

    public void setConnectionName(String connectionName)
    {
        this.connectionName = connectionName;
    }

    public String getDeviceName()
    {
        return deviceName;
    }

    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }

    public int getHistoryDays()
    {
        return historyDays;
    }

    public void setHistoryDays(int historyDays)
    {
        this.historyDays = historyDays;
    }

    public Date getStartConnection()
    {
        return startConnection;
    }

    public void setStartConnection(Date startConnection)
    {
        this.startConnection = startConnection;
    }
}
