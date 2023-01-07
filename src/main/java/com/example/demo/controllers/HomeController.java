package com.example.demo.controllers;

import com.example.demo.service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
    private final UserServiceImpl userServiceImpl;
    @Autowired
    public HomeController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping("/")
    public ModelAndView getWelcomePage() throws JsonProcessingException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/welcome");
        modelAndView.addObject("date", userServiceImpl.getLocalDate());
        modelAndView.addObject("location", userServiceImpl.city);
        modelAndView.addObject("weather", userServiceImpl.getCurrentWeather());
        return modelAndView;
    }

}
