package com.has.adminhub.backend.services;

import com.has.adminhub.backend.entities.Device;

import java.util.List;

public interface DeviceService {
    Device addDevice(Device device);
    Device updateDevice(Long id, Device device);
    void deleteDevice(Long id);
    List<Device> getAllDevices();
}

