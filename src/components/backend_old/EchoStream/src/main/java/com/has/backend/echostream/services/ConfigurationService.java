package com.has.backend.echostream.services;

import com.has.backend.echostream.models.Configuration;
import com.has.backend.echostream.repos.ConfigurationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {
    private final ConfigurationRepository repository;

    public ConfigurationService(ConfigurationRepository repository) {
        this.repository = repository;
    }

    public List<Configuration> findAll() {
        return repository.findAll();
    }

    public Configuration save(Configuration config) {
        return repository.save(config);
    }

    public Configuration findByKey(String key) {
        return repository.findByKey(key);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
