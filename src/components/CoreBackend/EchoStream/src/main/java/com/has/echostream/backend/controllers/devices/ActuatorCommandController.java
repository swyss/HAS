package com.has.echostream.backend.controllers.devices;

import com.has.echostream.backend.models.device.ActuatorCommand;
import com.has.echostream.backend.services.device.ActuatorCommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/device/actuator-commands")
public class ActuatorCommandController {

    private final ActuatorCommandService actuatorCommandService;

    public ActuatorCommandController(ActuatorCommandService actuatorCommandService) {
        this.actuatorCommandService = actuatorCommandService;
    }

    @PostMapping
    public ResponseEntity<ActuatorCommand> createCommand(@RequestBody ActuatorCommand command) {
        ActuatorCommand savedCommand = actuatorCommandService.saveCommand(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCommand);
    }
}

