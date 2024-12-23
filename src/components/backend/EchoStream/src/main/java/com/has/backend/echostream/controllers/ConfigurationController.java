package com.has.backend.echostream.controllers;

import com.has.backend.echostream.models.Configuration;
import com.has.backend.echostream.services.ConfigurationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/configurations")
public class ConfigurationController {

    private final ConfigurationService service;

    public ConfigurationController(ConfigurationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Configuration> getAllConfigurations() {
        return service.findAll();
    }

    @GetMapping("/{key}")
    public ResponseEntity<Configuration> getConfigurationByKey(@PathVariable String key) {
        Configuration config = service.findByKey(key);
        return config != null ? ResponseEntity.ok(config) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Configuration createConfiguration(@RequestBody Configuration config) {
        return service.save(config);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConfiguration(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
