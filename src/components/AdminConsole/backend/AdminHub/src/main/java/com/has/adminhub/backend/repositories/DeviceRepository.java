package com.has.adminhub.backend.repositories;

import com.has.adminhub.backend.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}

