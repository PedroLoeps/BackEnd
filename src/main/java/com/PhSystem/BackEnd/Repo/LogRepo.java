package com.PhSystem.BackEnd.Repo;

import com.PhSystem.BackEnd.Models.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepo extends JpaRepository<Log, Integer> {

    List<Log> findBySensor(String sensor);
}
