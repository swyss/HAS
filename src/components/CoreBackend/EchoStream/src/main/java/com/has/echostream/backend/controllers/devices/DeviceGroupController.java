package com.has.echostream.backend.controllers.devices;

import com.has.echostream.backend.models.device.DeviceGroup;
import com.has.echostream.backend.services.device.DeviceGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device/device-groups")
public class DeviceGroupController {

    private final DeviceGroupService deviceGroupService;

    public DeviceGroupController(DeviceGroupService deviceGroupService) {
        this.deviceGroupService = deviceGroupService;
    }

    @GetMapping
    public List<DeviceGroup> getAllDeviceGroups() {
        return deviceGroupService.getAllDeviceGroups();
    }

    @PostMapping
    public ResponseEntity<DeviceGroup> createDeviceGroup(@RequestBody DeviceGroup deviceGroup) {
        DeviceGroup savedGroup = deviceGroupService.saveDeviceGroup(deviceGroup);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGroup);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeviceGroup(@PathVariable Long id) {
        deviceGroupService.deleteDeviceGroup(id);
        return ResponseEntity.noContent().build();
    }
}

