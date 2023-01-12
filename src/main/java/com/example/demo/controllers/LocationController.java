package com.example.demo.controllers;

import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;

@RestController
public class LocationController {
    private final UserService userService;

    public LocationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/update_permission")
    public void updatePermissionDate(Date date){

    }
}
