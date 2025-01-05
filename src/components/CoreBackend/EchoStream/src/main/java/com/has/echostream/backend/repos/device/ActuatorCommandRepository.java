package com.has.echostream.backend.repos.device;

import com.has.echostream.backend.models.device.ActuatorCommand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActuatorCommandRepository extends JpaRepository<ActuatorCommand, Long> {
    List<ActuatorCommand> findByStatus(String status);
}

