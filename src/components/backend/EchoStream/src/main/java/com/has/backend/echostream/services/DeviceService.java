package com.has.backend.echostream.services;

import com.has.backend.echostream.models.Device;
import com.has.backend.echostream.repos.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    private final DeviceRepository repository;

    public DeviceService(DeviceRepository repository) {
        this.repository = repository;
    }

    public List<Device> findAll() {
        return repository.findAll();
    }

    public Device save(Device device) {
        return repository.save(device);
    }

    public Device findBySerialNumber(String serialNumber) {
        return repository.findBySerialNumber(serialNumber);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
