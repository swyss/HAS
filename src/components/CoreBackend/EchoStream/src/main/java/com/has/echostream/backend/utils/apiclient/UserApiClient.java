package com.has.echostream.backend.helpers.apiclient;


import com.has.echostream.backend.models.core.HAS_User;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;

@Component
public class UserApiClient {

    private final WebClient webClient;

    public UserApiClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public List<HAS_User> getAllUsers() {
        try {
            return webClient.get()
                    .uri("/users")
                    .retrieve()
                    .bodyToFlux(HAS_User.class)
                    .collectList()
                    .block();
        } catch (WebClientResponseException e) {
            throw new RuntimeException("Error fetching users: " + e.getMessage());
        }
    }

    public HAS_User getUserByUsername(String username) {
        try {
            return webClient.get()
                    .uri("/users/{username}", username)
                    .retrieve()
                    .bodyToMono(HAS_User.class)
                    .block();
        } catch (WebClientResponseException e) {
            throw new RuntimeException("Error fetching user: " + e.getMessage());
        }
    }

    public HAS_User createUser(HAS_User user) {
        try {
            return webClient.post()
                    .uri("/users")
                    .bodyValue(user)
                    .retrieve()
                    .bodyToMono(HAS_User.class)
                    .block();
        } catch (WebClientResponseException e) {
            throw new RuntimeException("Error creating user: " + e.getMessage());
        }
    }

    public void deleteUser(Long id) {
        try {
            webClient.delete()
                    .uri("/users/{id}", id)
                    .retrieve()
                    .toBodilessEntity()
                    .block();
        } catch (WebClientResponseException e) {
            throw new RuntimeException("Error deleting user: " + e.getMessage());
        }
    }
}

