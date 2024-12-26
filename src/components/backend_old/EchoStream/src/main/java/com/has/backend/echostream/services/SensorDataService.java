package com.has.backend.echostream.services;

import com.has.backend.echostream.models.SensorData;
import com.has.backend.echostream.repos.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorDataService {
    private final SensorDataRepository repository;

    public SensorDataService(SensorDataRepository repository) {
        this.repository = repository;
    }

    public List<SensorData> findByDeviceId(Long deviceId) {
        return repository.findByDeviceId(deviceId);
    }

    public SensorData save(SensorData data) {
        return repository.save(data);
    }
}
