package com.example.demo;

import com.example.demo.models.User;
import com.example.demo.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        User user = new User("User", "Userov", new Date(),
                "Male","Kazakhstan", "user@gmail.com", "user");
        user.setId(1L);
        userService.save(user);
    }
}
