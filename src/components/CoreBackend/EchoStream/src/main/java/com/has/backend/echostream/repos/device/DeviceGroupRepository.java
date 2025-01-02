package com.has.backend.echostream.repos.device;

import com.has.backend.echostream.models.device.DeviceGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceGroupRepository extends JpaRepository<DeviceGroup, Long> {
    DeviceGroup findByName(String name);
}

