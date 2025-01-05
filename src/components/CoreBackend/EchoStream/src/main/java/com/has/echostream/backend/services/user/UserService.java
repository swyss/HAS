package com.has.echostream.backend.services.user;

import com.has.echostream.backend.models.core.HAS_User;
import com.has.echostream.backend.repos.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public HAS_User registerUser(HAS_User user) {
        Optional<HAS_User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        return userRepository.save(user);
    }

    public List<HAS_User> getAllUsers() {
        return userRepository.findAll();
    }

    public HAS_User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

