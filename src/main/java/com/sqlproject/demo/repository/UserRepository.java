package com.sqlproject.demo.repository;

import com.sqlproject.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<List<User>> findByEmail(String email);
    Optional<List<User>> findByEmailAndAge(String email, Integer age);
}