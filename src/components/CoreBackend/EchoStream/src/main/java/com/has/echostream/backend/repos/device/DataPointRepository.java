package com.has.echostream.backend.repos.device;

import com.has.echostream.backend.models.device.DataPoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataPointRepository extends JpaRepository<DataPoint, Long> {
    List<DataPoint> findByType(String type);
}
