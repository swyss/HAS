package com.has.backend.echostream.controllers;

import com.has.backend.echostream.models.Device;
import com.has.backend.echostream.services.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    private final DeviceService service;

    public DeviceController(DeviceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Device> getAllDevices() {
        return service.findAll();
    }

    @GetMapping("/{serialNumber}")
    public ResponseEntity<Device> getDeviceBySerialNumber(@PathVariable String serialNumber) {
        Device device = service.findBySerialNumber(serialNumber);
        return device != null ? ResponseEntity.ok(device) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Device createDevice(@RequestBody Device device) {
        return service.save(device);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
