package com.sqlproject.demo.service.Impl;

import com.sqlproject.demo.dto.UserDTO;
import com.sqlproject.demo.model.User;
import com.sqlproject.demo.repository.UserRepository;
import com.sqlproject.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<UserDTO> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO createUser(UserDTO user) {
        return modelMapper.map(userRepository.save(modelMapper.map(user, User.class)), UserDTO.class);

    }

    public UserDTO findByID(UUID id) {
        return modelMapper.map(userRepository.findById(id), UserDTO.class);
    }

    public List<UserDTO> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public List<UserDTO> findByEmailAndAge(String email, Integer age) {
        return userRepository.findByEmailAndAge(email, age)
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public boolean deleteByID(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
