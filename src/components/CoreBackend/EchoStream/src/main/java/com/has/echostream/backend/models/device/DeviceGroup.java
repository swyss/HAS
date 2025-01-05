package com.has.echostream.backend.models.device;

import com.has.echostream.backend.models.core.HAS_Device;
import com.has.echostream.backend.models.shared.core.HAS_SysId;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "device_group")
public class DeviceGroup extends HAS_SysId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "device_group_id")
    private Long id;

    @Column(nullable = false)
    private String name;


    @OneToMany(mappedBy = "deviceGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HAS_Device> devices = new HashSet<>();
}