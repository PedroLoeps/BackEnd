package com.PhSystem.BackEnd.Controller;


import com.PhSystem.BackEnd.Models.Sensor;
import com.PhSystem.BackEnd.Service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "sensor")
public class SensorController {

    @Autowired
    private final SensorService sensorService;
    /*
    @Autowired
    private EmailService emailService;
     */

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    /*@GetMapping(value = "/")
    public String getPage() {
        emailService.sendEmail("pedroantonio.antuneslopes03@gmail.com", "Alarm", "New Alarm Detected");
        return "Welcome";
    }*/

    @GetMapping(value = "/all")
    public List<Sensor> getSensor() {
        return sensorService.getSensors();
    }

    @GetMapping(value = "/{clientId}")
    public List<Sensor> getClientSensors(@PathVariable("clientId") String clientId) {
        return sensorService.getClientSensors(clientId);

    /*
    @PostMapping(value = "/save")
    public String saveSensor(@RequestBody Sensor sensor) {
        sensorRepo.save(sensor);
        return "Saved...";
    }


    @PutMapping(value = "/update/{id}")
    public String updateSensor(@PathVariable String id, @RequestBody Sensor sensor) {
        Sensor updateSensor = sensorRepo.findById(id).get();
        updateSensor.setClient(sensor.getClient());
        updateSensor.setName(sensor.getName());
        sensorRepo.save(updateSensor);
        return "Updated...";
    }


    @DeleteMapping(value = "/delete/{id}")
    public String deleteSensor(@PathVariable String id) {
        Sensor deleteSensor = sensorRepo.findById(id).get();
        sensorRepo.delete(deleteSensor);
        return "Deleted...";*/
    }


}
