package com.sqlproject.demo.controller;

import com.sqlproject.demo.dto.UserDTO;
import com.sqlproject.demo.model.User;
import com.sqlproject.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Controller
@RequiredArgsConstructor
public class Test {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @PostConstruct
    public void testFlow() throws InterruptedException, ExecutionException {
//        Future<User> futureUser = userService.createUser(User.builder()
////                .id(UUID.fromString("54d814d4-6b94-4ac0-b435-ce7505b33888"))
//                .name("George")
//                .age(211)
//                .email("adree112ian@transiris.com")
//                .build());
//        while (true) {
//            if (futureUser.isDone()) {
//                UserDTO userDto = modelMapper.map(futureUser, UserDTO.class);
//                System.out.println("\n\n" + userDto + "\n\n");
//                break;
//            }
//            System.out.println("Continue createUser on " + Thread.currentThread() + " ...");
//            Thread.sleep(1000);
//        }


        Future<List<User>> futureAllUsers = userService.findAllUsers();
        while (true) {
            if (futureAllUsers.isDone()) {

                List<UserDTO> allUsersDTOs = new ArrayList<>();
                for (User x : futureAllUsers.get()) {
                    UserDTO y = modelMapper.map(x, UserDTO.class);
                    System.out.println("\n\n" + y + "\n\n");
                }

                break;
            }
            System.out.println("Continue allUsers on " + Thread.currentThread() + " ...");
            Thread.sleep(1000);
        }


//        List<User> emailUser = userService.findByEmail("adrifsafsafsaan@transiris.com");
//        System.out.println(emailUser);
//
//        List<User> emailAndAgeUser = userService.findByEmailAndAge("adrifsafsafsaan@transiris.com", 21);
//        System.out.println(emailAndAgeUser);
    }
}
