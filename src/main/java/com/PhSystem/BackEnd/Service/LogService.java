package com.PhSystem.BackEnd.Service;

import com.PhSystem.BackEnd.Models.Log;
import com.PhSystem.BackEnd.Repo.LogRepo;
import com.PhSystem.BackEnd.Repo.SensorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    private final LogRepo logRepo;

    public LogService(LogRepo logRepo, SensorRepo sensorRepo) {
        this.logRepo = logRepo;
    }

    public List<Log> getLogs() {
        return logRepo.findAll();
    }

    public List<Log> getSensorLogs(String sensorId) {
        return logRepo.findBySensor(sensorId);
    }

}
