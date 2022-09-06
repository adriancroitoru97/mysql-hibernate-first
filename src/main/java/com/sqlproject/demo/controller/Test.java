package com.sqlproject.demo.controller;

import com.sqlproject.demo.dto.UserDTO;
import com.sqlproject.demo.model.User;
import com.sqlproject.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class Test {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @PostConstruct
    public void testFlow() {
        User user = userService.createUser(User.builder()
                .id(UUID.fromString("54d814d4-6b94-4ac0-b435-ce7505b33888"))
                .name("Adrian")
                .age(21)
                .email("adrian@transiris.com")
                .build());
        UserDTO userDto = modelMapper.map(user, UserDTO.class);
        System.out.println("\n\n" + userDto + "\n\n");


        List<User> allUsers = userService.findAllUsers();
        List<UserDTO> allUsersDTOs = new ArrayList<>();
        for (User x : allUsers) {
            UserDTO y = modelMapper.map(x, UserDTO.class);
            System.out.println("\n\n" + y + "\n\n");
        }


//        List<User> emailUser = userService.findByEmail("adrifsafsafsaan@transiris.com");
//        System.out.println(emailUser);
//
//        List<User> emailAndAgeUser = userService.findByEmailAndAge("adrifsafsafsaan@transiris.com", 21);
//        System.out.println(emailAndAgeUser);
    }
}
