package com.sqlproject.demo.repository;

import com.sqlproject.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<List<User>> findByEmail(String email);
    Optional<List<User>> findByEmailAndAge(String email, Integer age);
}