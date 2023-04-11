package com.PhSystem.BackEnd.Controller;


import com.PhSystem.BackEnd.Models.Log;
import com.PhSystem.BackEnd.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "log")
public class LogController {

    @Autowired
    private final LogService logService;


    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping(value = "/{sensorId}")
    public List<Log> getSensorLogs(@PathVariable("sensorId") String sensorId) {
        return logService.getSensorLogs(sensorId);
    }

    @GetMapping(value = "/all")
    public List<Log> getLogs() {
        return logService.getLogs();
    }
}
