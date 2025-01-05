package com.has.echostream.backend.services.core;

import com.has.echostream.backend.models.core.HAS_Device;
import com.has.echostream.backend.repos.core.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<HAS_Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public HAS_Device getDeviceBySerialNumber(String serialNumber) {
        return deviceRepository.findBySerialNumber(serialNumber)
                .orElseThrow(() -> new RuntimeException("Device not found"));
    }

    public List<HAS_Device> getDevicesByType(String type) {
        return deviceRepository.findByType(type);
    }

    public List<HAS_Device> getDevicesByStatus(String status) {
        return deviceRepository.findByStatus(status);
    }

    public HAS_Device saveDevice(HAS_Device device) {
        return deviceRepository.save(device);
    }

    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }
}

