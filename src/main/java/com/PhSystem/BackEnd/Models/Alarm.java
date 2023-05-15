package com.PhSystem.BackEnd.Models;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ALARM")
public class Alarm {

    @Id
    @Column(name = "Alarm_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Sensor")
    private String sensor;

    @Column(name = "Alarm_Type")
    private int alarmType;

    @Column(name = "Alarm_Time")
    private Date time;

    public Alarm() {
    }

    public Alarm(String sensor, int alarmType, Date time) {
        this.sensor = sensor;
        this.alarmType = alarmType;
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
        this.sensor = sensor;
    }

    public int getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(int alarmType) {
        this.alarmType = alarmType;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
