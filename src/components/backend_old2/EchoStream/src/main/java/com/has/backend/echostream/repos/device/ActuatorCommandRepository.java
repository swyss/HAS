package com.has.backend.echostream.repos.device;

import com.has.backend.echostream.models.device.ActuatorCommand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActuatorCommandRepository extends JpaRepository<ActuatorCommand, Long> {
        List<ActuatorCommand> findByStatus(String status);
}

