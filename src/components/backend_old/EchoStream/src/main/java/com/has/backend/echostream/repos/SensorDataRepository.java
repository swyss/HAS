package com.has.backend.echostream.repos;

import com.has.backend.echostream.models.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
    List<SensorData> findByDeviceId(Long deviceId);
}
