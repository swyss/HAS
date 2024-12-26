package com.has.backend.echostream.repos.device;

import com.has.backend.echostream.models.device.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
    List<SensorData> findByDeviceId(Long deviceId);
    List<SensorData> findByIsAnomalous(Boolean isAnomalous);
}
