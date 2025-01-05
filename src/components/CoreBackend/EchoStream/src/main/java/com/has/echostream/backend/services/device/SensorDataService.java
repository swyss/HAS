package com.has.echostream.backend.services.device;

import com.has.echostream.backend.models.device.SensorData;
import com.has.echostream.backend.repos.device.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorDataService {

    private final SensorDataRepository sensorDataRepository;

    public SensorDataService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    public List<SensorData> getAnomalousData() {
        return sensorDataRepository.findByIsAnomalous(true);
    }

    public SensorData saveSensorData(SensorData data) {
        return sensorDataRepository.save(data);
    }
}

