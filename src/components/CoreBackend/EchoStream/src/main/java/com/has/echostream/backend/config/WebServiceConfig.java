package com.has.echostream.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.DelegatingWsConfiguration;

@Configuration
public class WebServiceConfig {

    @Bean
    public static DelegatingWsConfiguration delegatingWsConfiguration() {
        return new DelegatingWsConfiguration();
    }
}

