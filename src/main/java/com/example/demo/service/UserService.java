package com.example.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDate;

public interface UserService {
    LocalDate getLocalDate() ;

    void getLocation() ;

    String getCurrentWeather();

}



