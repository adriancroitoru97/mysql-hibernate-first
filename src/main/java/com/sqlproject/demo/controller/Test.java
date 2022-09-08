package com.sqlproject.demo.controller;

import com.sqlproject.demo.dto.AddressDTO;
import com.sqlproject.demo.dto.UserDTO;
import com.sqlproject.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class Test {
    private final UserService userService;

    @PostConstruct
    @Async
    public void testFlow() {
        UserDTO newUser = userService.createUser(UserDTO.builder()
                .name("Adrian")
                .age(21)
                .email("adrian@transiris.com")
                .address(AddressDTO
                        .builder()
                        .city("Bucharest")
                        .country("Romania")
                        .build())
                .build());
        System.out.println("\n\n" + newUser + "\n\n");


        List<UserDTO> allUsers = userService.findAllUsers();
        System.out.println(allUsers);
    }
}
