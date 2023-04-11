package com.PhSystem.BackEnd.Models;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "LOGS")
public class Log {

    @Id
    @Column(name = "Log_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Sensor")
    private String sensor;

    @Column(name = "Temp")
    private int temp;

    @Column(name = "Ph")
    private float ph;

    @Column(name = "Log_Time")
    private Date time;

    public Log() {

    }

    public Log(String sensor, int temp, float ph, Date time) {
        this.sensor = sensor;
        this.temp = temp;
        this.ph = ph;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        sensor = sensor;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        temp = temp;
    }

    public float getPh() {
        return ph;
    }

    public void setPh(float ph) {
        ph = ph;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        time = time;
    }
}
