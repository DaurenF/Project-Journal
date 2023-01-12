package com.example.demo.controllers;

import com.example.demo.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/api")
public class HomeRestController {
    private final UserServiceImpl userService;

    public HomeRestController(UserServiceImpl userService) {
        this.userService = userService;
    }
    @GetMapping("/get_exp_date")
    public ResponseEntity<Map<String, Integer>> getUserPermExpDate(){
        LocalDate localDate = userService.getUserByUsername(SecurityContextHolder.
                getContext().getAuthentication().getName()).getExp_date();
        Map<String, Integer>result =new HashMap<>();
        result.put("year",localDate.getYear());
        result.put("month", localDate.getMonthValue());
        result.put("day", localDate.getDayOfMonth());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/get_info_after_perm")
    public ResponseEntity<Map<String, String>> getLocationAndWeather(){
        Map<String, String>result =new HashMap<>();
        result.put("date", String.valueOf(userService.getLocalDate()));
        userService.getLocation();
        result.put("location", userService.getCity());
        result.put("weather", userService.getCurrentWeather());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
