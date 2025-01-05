package com.has.backend.adminhub.repositories;

import com.has.backend.adminhub.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
