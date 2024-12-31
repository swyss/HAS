package com.has.backend.echostream.controllers.devices;

import com.has.backend.echostream.models.device.DataPoint;
import com.has.backend.echostream.services.device.DataPointService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device/data-points")
public class DataPointController {

    private final DataPointService dataPointService;

    public DataPointController(DataPointService dataPointService) {
        this.dataPointService = dataPointService;
    }

    @GetMapping("/type/{type}")
    public List<DataPoint> getDataPointsByType(@PathVariable String type) {
        return dataPointService.getDataPointsByType(type);
    }

    @PostMapping
    public ResponseEntity<DataPoint> createDataPoint(@RequestBody DataPoint dataPoint) {
        DataPoint savedDataPoint = dataPointService.saveDataPoint(dataPoint);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDataPoint);
    }
}

