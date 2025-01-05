package com.has.echostream.backend.repos.device;

import com.has.echostream.backend.models.device.DeviceGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceGroupRepository extends JpaRepository<DeviceGroup, Long> {
    DeviceGroup findByName(String name);
}

