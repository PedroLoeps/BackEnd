package com.PhSystem.BackEnd.Service;

import com.PhSystem.BackEnd.Models.Alarm;
import com.PhSystem.BackEnd.Repo.AlarmRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmService {

    private final AlarmRepo alarmRepo;


    public AlarmService(AlarmRepo alarmRepo) {
        this.alarmRepo = alarmRepo;
    }

    public List<Alarm> getAlarms() {
        return alarmRepo.findAll();
    }

    public List<Alarm> getSensorAlarms(String sensorId){
        return alarmRepo.findBySensor(sensorId);
    }
}
