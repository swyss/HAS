package com.has.backend.echostream.repos;

import com.has.backend.echostream.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    Device findBySerialNumber(String serialNumber);
}
