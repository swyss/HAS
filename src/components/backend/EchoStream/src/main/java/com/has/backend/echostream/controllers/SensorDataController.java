package com.has.backend.echostream.controllers;

import com.has.backend.echostream.models.SensorData;
import com.has.backend.echostream.services.SensorDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensor-data")
public class SensorDataController {

    private final SensorDataService service;

    public SensorDataController(SensorDataService service) {
        this.service = service;
    }

    @GetMapping("/{deviceId}")
    public List<SensorData> getSensorDataByDeviceId(@PathVariable Long deviceId) {
        return service.findByDeviceId(deviceId);
    }

    @PostMapping
    public SensorData createSensorData(@RequestBody SensorData data) {
        return service.save(data);
    }
}
