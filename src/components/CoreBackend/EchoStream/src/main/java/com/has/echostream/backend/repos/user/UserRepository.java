package com.has.echostream.backend.repos.user;


import com.has.echostream.backend.models.core.HAS_User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<HAS_User, Long> {
    Optional<HAS_User> findByUsername(String username);
}

