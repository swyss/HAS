package com.has.core_backend.echostream.services.device;

import com.has.core_backend.echostream.models.device.SensorData;
import com.has.core_backend.echostream.repos.device.SensorDataRepository;
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

