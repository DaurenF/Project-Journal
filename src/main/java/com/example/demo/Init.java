package com.example.demo;

import com.example.demo.models.User;
import com.example.demo.service.user.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Init {
    private final UserService userService;

    public Init(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void initUser() {
        User user = new User("User", "Userov", "user", new Date(),
                "Male", "Kazakhstan", "user@gmail.com", "password");
        user.setId(1L);
        userService.save(user);
    }
}
