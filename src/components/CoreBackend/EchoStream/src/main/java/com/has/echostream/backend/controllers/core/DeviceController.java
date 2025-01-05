package com.has.echostream.backend.controllers.core;

import com.has.echostream.backend.models.core.HAS_Device;
import com.has.echostream.backend.services.core.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(DeviceController.BASE_PATH)
public class DeviceController {
    public static final String BASE_PATH = "/api/devices";

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
        HAS_Device savedDevice = persistDevice(device);
        return buildCreatedResponse(savedDevice);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return buildNoContentResponse();
    }

    // Extracted private methods for reuse and better organization
    private HAS_Device persistDevice(HAS_Device device) {
        return deviceService.saveDevice(device);
    }

    private ResponseEntity<HAS_Device> buildCreatedResponse(HAS_Device savedDevice) {
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDevice);
    }

    private ResponseEntity<Void> buildNoContentResponse() {
        return ResponseEntity.noContent().build();
    }
}