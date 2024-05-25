package com.alco.iot.controller;

import com.alco.iot.model.SensorReading;
import com.alco.iot.service.SensorReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/readings")
public class SensorReadingController {

    private final SensorReadingService sensorReadingService;

    @Autowired
    public SensorReadingController(SensorReadingService sensorReadingService) {
        this.sensorReadingService = sensorReadingService;
    }

    @PostMapping // POST request to /api/readings
    public ResponseEntity<SensorReading> save(@RequestBody SensorReading sensorReading) {
        SensorReading savedReading = sensorReadingService.save(sensorReading);
        return new ResponseEntity<>(savedReading, HttpStatus.CREATED);
    }
}
