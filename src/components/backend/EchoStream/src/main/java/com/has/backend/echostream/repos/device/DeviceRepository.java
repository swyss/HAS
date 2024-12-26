package com.has.backend.echostream.repos.device;

import com.has.backend.echostream.models.device.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    Optional<Device> findBySerialNumber(String serialNumber);
    List<Device> findByType(String type);
    List<Device> findByStatus(String status);
}

