package com.has.backend.echostream.repos.core;

import com.has.backend.echostream.models.core.HAS_Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<HAS_Session, Long> {
    Optional<HAS_Session> findByToken(String token);

    void deleteByToken(String token);

    List<HAS_Session> findByUserId(Long userId);

}

