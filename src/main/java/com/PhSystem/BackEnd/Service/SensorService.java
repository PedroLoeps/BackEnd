package com.PhSystem.BackEnd.Service;


import com.PhSystem.BackEnd.Models.CanView;
import com.PhSystem.BackEnd.Models.Sensor;
import com.PhSystem.BackEnd.Repo.CanViewRepo;
import com.PhSystem.BackEnd.Repo.SensorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

    private final SensorRepo sensorRepo;

    private final CanViewRepo canViewRepo;

    public SensorService(SensorRepo sensorRepo, CanViewRepo canViewRepo) {
        this.sensorRepo = sensorRepo;
        this.canViewRepo = canViewRepo;
    }

    public List<Sensor> getSensors() {
        return sensorRepo.findAll();
    }

    public List<Sensor> getClientSensors(String clientId) {
        List<Sensor> clientSensors = sensorRepo.findByClient(clientId);

        List<CanView> canViewSensors = canViewRepo.findByClient(clientId);
        for(CanView sensor : canViewSensors) {
            clientSensors.add(sensorRepo.findById(sensor.getSensor()).get());
        }

        return clientSensors;
    }
}
