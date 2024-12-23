package com.has.backend.echostream.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ActuatorCommand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    private Device device; // Associated device

    private String command; // Command type (e.g., TURN_ON, TURN_OFF)

    @Column(nullable = false)
    private LocalDateTime timestamp; // Time when the command was issued

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
