package com.has.backend.echostream.services;

import com.has.backend.echostream.models.SensorData;
import com.has.backend.echostream.repos.SensorDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnomalyDetectionService {
    private final SensorDataRepository repository;
    // Define the threshold value
    private static final Double THRESHOLD = 75.0;

    public AnomalyDetectionService(SensorDataRepository repository) {
        this.repository = repository;
    }

    public List<SensorData> detectAnomalies() {
        // Example logic for detecting anomalies
        return repository.findAll().stream()
                .filter(data -> data.getValue() > THRESHOLD) // Replace THRESHOLD with actual logic
                .peek(data -> data.setIsAnomalous(true))
                .toList();
    }

    public void resolveAnomaly(Long id) {
        SensorData data = repository.findById(id).orElseThrow(() -> new RuntimeException("Data not found"));
        data.setIsAnomalous(false);
        repository.save(data);
    }
}
