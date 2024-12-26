package com.has.backend.echostream.repos.core;

import com.has.backend.echostream.models.core.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {
    Optional<Session> findByToken(String token);

    void deleteByToken(String token);
}

