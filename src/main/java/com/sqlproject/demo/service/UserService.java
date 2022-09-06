package com.sqlproject.demo.service;

import com.sqlproject.demo.model.User;
import com.sqlproject.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.Future;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Async
    public Future<List<User>> findAllUsers() {
        try {
            Thread.sleep(5000);
            return new AsyncResult<>(userRepository.findAll());
        } catch (InterruptedException ignored) {
        }

        return null;
    }

//    @Async
    public Future<User> createUser(User user) {
        try {
            Thread.sleep(5000);
            return new AsyncResult<>(userRepository.save(user));
        } catch (InterruptedException ignored) {
        }

        return null;
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
