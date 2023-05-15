package com.PhSystem.BackEnd.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "CAN_VIEW")
public class CanView {

    @Id
    @Column(name = "View_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Client")
    private String client;

    @Column(name = "Sensor")
    private String sensor;

    public CanView() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }
}
