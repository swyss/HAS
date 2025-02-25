package com.has.echostream.backend.repos.core;

import com.has.echostream.backend.models.core.HAS_Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeviceRepository extends JpaRepository<HAS_Device, Long> {
    Optional<HAS_Device> findBySerialNumber(String serialNumber);

    List<HAS_Device> findByType(String type);

    List<HAS_Device> findByStatus(String status);
}

