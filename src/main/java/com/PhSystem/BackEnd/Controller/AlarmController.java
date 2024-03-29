package com.PhSystem.BackEnd.Controller;

import com.PhSystem.BackEnd.Models.Alarm;
import com.PhSystem.BackEnd.Service.AlarmService;
import com.PhSystem.BackEnd.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "alarm")
public class AlarmController {

    @Autowired
    private final AlarmService alarmService;

    @Autowired
    private EmailService emailService;


    public AlarmController(AlarmService alarmService) {
        this.alarmService = alarmService;
    }

    @GetMapping(value = "/all")
    public List<Alarm> getAlarms() {
        emailService.sendEmail("pedroantonio.antuneslopes03@gmail.com", "Alarm", "New Alarm Detected");
        return alarmService.getAlarms();
    }

    @GetMapping(value = "/{sensorId}")
    public List<Alarm> getSensorAlarms(@PathVariable("sensorId") String sensorId) {
        return alarmService.getSensorAlarms(sensorId);
    }
}
