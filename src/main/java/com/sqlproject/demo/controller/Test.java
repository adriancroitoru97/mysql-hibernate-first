package com.sqlproject.demo.controller;

import com.sqlproject.demo.model.User;
import com.sqlproject.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class Test {
    private final UserService userService;

    @PostConstruct
    public void testFlow() {
//        User user = userService.createUser(User.builder()
//                .name("Sergiu")
//                .age(221)
//                .email("adrifsafsafsaan@transiris.com")
//                .build());
//        System.out.println(user);

        List<User> allUsers = userService.findAllUsers();
        System.out.println(allUsers);

        List<User> emailUser = userService.findByEmail("adrifsafsafsaan@transiris.com");
        System.out.println(emailUser);

        List<User> emailAndAgeUser = userService.findByEmailAndAge("adrifsafsafsaan@transiris.com", 21);
        System.out.println(emailAndAgeUser);
    }
}
