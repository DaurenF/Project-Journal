package com.example.demo.service;

import com.example.demo.models.User;

import java.time.LocalDate;
import java.util.Date;

public interface UserService {
    LocalDate getLocalDate() ;

    void getLocation() ;

    String getCurrentWeather();

    Date getExpirationDatePermission();
    void save(User user);

}



