package com.has.echostream.backend.utils.apiclient;

import com.has.echostream.backend.models.core.HAS_Device;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class DeviceApiClient {

    private final WebClient webClient;

    public DeviceApiClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<HAS_Device> getAllDevices() {
        return webClient.get()
                .uri("/devices")
                .retrieve()
                .bodyToFlux(HAS_Device.class)
                .collectList()
                .block();
    }

    public HAS_Device getDeviceBySerialNumber(String serialNumber) {
        return webClient.get()
                .uri("/devices/{serialNumber}", serialNumber)
                .retrieve()
                .bodyToMono(HAS_Device.class)
                .block();
    }

    public HAS_Device createDevice(HAS_Device HASDevice) {
        return webClient.post()
                .uri("/devices")
                .bodyValue(HASDevice)
                .retrieve()
                .bodyToMono(HAS_Device.class)
                .block();
    }

    public void deleteDevice(Long id) {
        webClient.delete()
                .uri("/devices/{id}", id)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}

