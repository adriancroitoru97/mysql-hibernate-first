package com.sqlproject.demo.service;

import com.sqlproject.demo.model.User;
import com.sqlproject.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findByID(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public List<User> findByEmailAndAge(String email, Integer age) {
        return userRepository.findByEmailAndAge(email, age).orElse(null);
    }

    public boolean deleteByID(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
