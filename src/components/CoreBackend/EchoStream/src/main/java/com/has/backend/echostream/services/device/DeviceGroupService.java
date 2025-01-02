package com.has.backend.echostream.services.device;

import com.has.backend.echostream.models.device.DeviceGroup;
import com.has.backend.echostream.repos.device.DeviceGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceGroupService {

    private final DeviceGroupRepository deviceGroupRepository;

    public DeviceGroupService(DeviceGroupRepository deviceGroupRepository) {
        this.deviceGroupRepository = deviceGroupRepository;
    }

    public List<DeviceGroup> getAllDeviceGroups() {
        return deviceGroupRepository.findAll();
    }

    public DeviceGroup getDeviceGroupByName(String name) {
        return deviceGroupRepository.findByName(name);
    }

    public DeviceGroup saveDeviceGroup(DeviceGroup deviceGroup) {
        return deviceGroupRepository.save(deviceGroup);
    }

    public void deleteDeviceGroup(Long id) {
        deviceGroupRepository.deleteById(id);
    }
}

