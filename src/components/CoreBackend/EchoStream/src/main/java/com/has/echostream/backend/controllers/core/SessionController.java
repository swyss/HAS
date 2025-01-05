package com.has.core_backend.echostream.controllers.core;

import com.has.core_backend.echostream.models.core.HAS_Session;
import com.has.core_backend.echostream.services.core.SessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping()
    public List<HAS_Session> getSessions() {
        return sessionService.getCurrentTop100();
    }

    @GetMapping("/user/{userId}")
    public List<HAS_Session> getSessionsByUserId(@PathVariable Long userId) {
        return sessionService.findByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<HAS_Session> createSession(@RequestBody HAS_Session session) {
        HAS_Session saveSession = sessionService.saveSession(session);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveSession);
    }

    @DeleteMapping("/{token}")
    public ResponseEntity<Void> deleteSessionByToken(@PathVariable String token) {
        sessionService.deleteSessionByToken(token);
        return ResponseEntity.noContent().build();
    }
}

