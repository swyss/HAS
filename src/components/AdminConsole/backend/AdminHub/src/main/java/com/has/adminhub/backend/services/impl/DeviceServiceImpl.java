package com.has.adminhub.backend.services.impl;

import com.has.adminhub.backend.entities.Device;
import com.has.adminhub.backend.repositories.DeviceRepository;
import com.has.adminhub.backend.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public Device updateDevice(Long id, Device device) {
        Device existingDevice = deviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Device not found"));
        existingDevice.setName(device.getName());
        existingDevice.setType(device.getType());
        existingDevice.setStatus(device.getStatus());
        existingDevice.setLocation(device.getLocation());
        return deviceRepository.save(existingDevice);
    }

    @Override
    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }
}

