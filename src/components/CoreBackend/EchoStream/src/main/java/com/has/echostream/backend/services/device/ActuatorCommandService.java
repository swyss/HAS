package com.has.core_backend.echostream.services.device;

import com.has.core_backend.echostream.models.device.ActuatorCommand;
import com.has.core_backend.echostream.repos.device.ActuatorCommandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActuatorCommandService {

    private final ActuatorCommandRepository actuatorCommandRepository;

    public ActuatorCommandService(ActuatorCommandRepository actuatorCommandRepository) {
        this.actuatorCommandRepository = actuatorCommandRepository;
    }

    public List<ActuatorCommand> getCommandsByStatus(String status) {
        return actuatorCommandRepository.findByStatus(status);
    }

    public ActuatorCommand saveCommand(ActuatorCommand command) {
        return actuatorCommandRepository.save(command);
    }
}

