package com.sqlproject.demo.service;

import com.sqlproject.demo.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDTO> findAllUsers();
    UserDTO createUser(UserDTO user);
    UserDTO findByID(UUID id);
    List<UserDTO> findByEmail(String email);
    List<UserDTO> findByEmailAndAge(String email, Integer age);
    boolean deleteByID(UUID id);
}
