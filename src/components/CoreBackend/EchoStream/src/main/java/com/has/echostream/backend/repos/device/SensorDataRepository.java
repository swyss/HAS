package com.has.echostream.backend.repos.device;

import com.has.echostream.backend.models.device.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

    List<SensorData> findByIsAnomalous(Boolean isAnomalous);
}
