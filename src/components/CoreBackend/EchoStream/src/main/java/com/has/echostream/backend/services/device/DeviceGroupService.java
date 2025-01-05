package com.has.echostream.backend.services.device;

import com.has.echostream.backend.models.device.DeviceGroup;
import com.has.echostream.backend.repos.device.DeviceGroupRepository;
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

