package com.has.backend.echostream.models.device;

import com.has.backend.echostream.models.core.HAS_Device;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "device_group")
public class DeviceGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_group_id")
    private Long id;

    @Column(nullable = false)
    private String name;


    @OneToMany(mappedBy = "device_group", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HAS_Device> devices = new HashSet<>();
}