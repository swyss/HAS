package com.has.echostream.backend.controllers.devices;

import com.has.echostream.backend.models.device.SensorData;
import com.has.echostream.backend.services.device.SensorDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device/sensor-data")
public class SensorDataController {

    private final SensorDataService sensorDataService;

    public SensorDataController(SensorDataService sensorDataService) {
        this.sensorDataService = sensorDataService;
    }

    @GetMapping("/anomalies")
    public List<SensorData> getAnomalousData() {
        return sensorDataService.getAnomalousData();
    }

    @PostMapping
    public ResponseEntity<SensorData> createSensorData(@RequestBody SensorData data) {
        SensorData savedData = sensorDataService.saveSensorData(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedData);
    }
}

