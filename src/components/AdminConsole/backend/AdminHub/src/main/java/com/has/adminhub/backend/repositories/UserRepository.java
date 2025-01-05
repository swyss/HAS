package com.has.adminhub.backend.repositories;

import com.has.adminhub.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
