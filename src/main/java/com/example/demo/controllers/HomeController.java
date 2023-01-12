package com.example.demo.controllers;

import com.example.demo.service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final UserServiceImpl userServiceImpl;
    @Autowired
    public HomeController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/")
    public String getWelcomePage(Model model){
        model.addAttribute("date", userServiceImpl.getLocalDate());
        model.addAttribute("location", userServiceImpl.getCity());
        model.addAttribute("weather", userServiceImpl.getCurrentWeather());
        return "welcome";
    }

}
