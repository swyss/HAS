package com.has.backend.echostream.services.core;

import com.has.backend.echostream.models.core.HAS_Session;
import com.has.backend.echostream.repos.core.SessionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Transactional
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public HAS_Session saveSession(HAS_Session session) {
        return sessionRepository.save(session);
    }

    public void deleteSessionByToken(String token) {
        sessionRepository.deleteByToken(token);
    }

    public List<HAS_Session> findByUserId(Long userId) {
        return sessionRepository.findByUserId(userId);
    }
}
