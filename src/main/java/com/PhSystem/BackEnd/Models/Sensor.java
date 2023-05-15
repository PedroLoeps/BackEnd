package com.PhSystem.BackEnd.Models;

import jakarta.persistence.*;


@Entity
@Table(name = "SENSOR")
public class Sensor {

    @Id
    @Column(name = "Sensor_Id")
    private String id;

    @Column(name = "Client")
    private String client;

    @Column(name = "Name")
    private String name;

    public Sensor() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
