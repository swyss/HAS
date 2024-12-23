package com.has.backend.echostream.services;

import com.has.backend.echostream.models.Session;
import com.has.backend.echostream.models.User;
import com.has.backend.echostream.repos.SessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SessionService {
    private final SessionRepository repository;

    public SessionService(SessionRepository repository) {
        this.repository = repository;
    }

    public Session createSession(User user, String token, LocalDateTime expiresAt) {
        Session session = new Session();
        session.setUser(user);
        session.setToken(token);
        session.setCreatedAt(LocalDateTime.now());
        session.setExpiresAt(expiresAt);
        return repository.save(session);
    }

    public void deleteSession(String token) {
        repository.deleteByToken(token);
    }

    public boolean isSessionValid(String token) {
        return repository.findByTokenAndExpiresAtAfter(token, LocalDateTime.now()).isPresent();
    }
}
