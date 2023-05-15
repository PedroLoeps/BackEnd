package com.PhSystem.BackEnd.Repo;

import com.PhSystem.BackEnd.Models.Client;
import com.PhSystem.BackEnd.Models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SensorRepo extends JpaRepository<Sensor, String> {

    List<Sensor> findByClient(String clientId);
}
