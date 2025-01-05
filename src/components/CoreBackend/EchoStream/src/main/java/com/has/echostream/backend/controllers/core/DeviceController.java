package com.has.core_backend.echostream.controllers.core;

import com.has.core_backend.echostream.models.core.HAS_Device;
import com.has.core_backend.echostream.services.core.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public List<HAS_Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/{serialNumber}")
    public ResponseEntity<HAS_Device> getDeviceBySerialNumber(@PathVariable String serialNumber) {
        HAS_Device device = deviceService.getDeviceBySerialNumber(serialNumber);
        return ResponseEntity.ok(device);
    }

    @PostMapping
    public ResponseEntity<HAS_Device> createDevice(@RequestBody HAS_Device device) {
        HAS_Device saveDevice = deviceService.saveDevice(device);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveDevice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }
}

