package com.PhSystem.BackEnd.Models;


import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
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

    @Column(name = "Ph_Entry")
    private float ph_entry;

    @Column(name = "Ph_Exit")
    private float ph_exit;

    @Column(name = "Log_Time")
    private Date time;

    public Log() {

    }

    public Log(String sensor, int temp, float ph_entry, float ph_exit, Date time) {
        this.sensor = sensor;
        this.temp = temp;
        this.ph_entry = ph_entry;
        this.ph_exit = ph_exit;
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

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public float getPh_entry() {
        return ph_entry;
    }

    public void setPh_entry(float ph_entry) {
        this.ph_entry = ph_entry;
    }

    public float getPh_exit() {
        return ph_exit;
    }

    public void setPh_exit(float ph_exit) {
        this.ph_exit = ph_ext;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
