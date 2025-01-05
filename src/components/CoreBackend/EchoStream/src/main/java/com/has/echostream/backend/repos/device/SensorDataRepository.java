package com.has.core_backend.echostream.repos.device;

import com.has.core_backend.echostream.models.device.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

    List<SensorData> findByIsAnomalous(Boolean isAnomalous);
}
