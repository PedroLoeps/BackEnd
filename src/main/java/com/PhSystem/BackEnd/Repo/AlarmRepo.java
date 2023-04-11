package com.PhSystem.BackEnd.Repo;

import com.PhSystem.BackEnd.Models.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlarmRepo extends JpaRepository<Alarm, Integer> {

    List<Alarm> findBySensor(String sensor);
}
