package com.has.backend.echostream.repos;

import com.has.backend.echostream.models.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
    Configuration findByKey(String key);
}
